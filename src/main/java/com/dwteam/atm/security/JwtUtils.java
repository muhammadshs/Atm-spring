package com.dwteam.atm.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.token.validity}")
    private Long jwtTokenValidity;


    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        try {
            final String jwt = Optional.ofNullable(token)
                    .map(String::trim)
                    .orElseThrow(() -> new IllegalArgumentException());
            if (isTokenExpired(jwt)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    /*public String generateToken(String token, String userField) {
        Claims claims = getAllClaimsFromToken(token);
        claims.put("userField", userField);

        return doGenerateToken(claims, claims.getSubject());
    }*/

    public String doGenerateToken(Long id, String subject) {
        return Jwts.builder().claim("id",id).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}
