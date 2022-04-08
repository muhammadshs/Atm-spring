package com.dwteam.atm.security;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@AllArgsConstructor
@Component
public class Filter extends OncePerRequestFilter {
    private TokenHolderService tokenHolderService;
    private JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url=request.getRequestURI();
        String requestHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
       // System.out.println(requestHeader);
        if (jwtUtils.validateToken(requestHeader)){
            Claims body=jwtUtils.getAllClaimsFromToken(requestHeader);
            System.out.println(body.get("id"));
            tokenHolderService.setter(Long.parseLong(body.get("id").toString()),body.getSubject());
            filterChain.doFilter(request,response);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path=request.getRequestURI();
        if (path.equals("/user/login") || path.equals("/user/register")||path.equals("/account/register")){
            return true;
        }
        return false;

    }
}
