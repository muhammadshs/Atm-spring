package com.dwteam.atm.security;

import com.dwteam.atm.exception.NotAccessException;
import com.dwteam.atm.exception.NotFindException;
import com.dwteam.atm.user.UserEntity;
import com.dwteam.atm.user.UserRepository;
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
import java.util.Optional;

@AllArgsConstructor
@Component
public class Filter extends OncePerRequestFilter {
    private TokenHolderService tokenHolderService;
    private JwtUtils jwtUtils;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url=request.getRequestURI();
        String requestHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwtUtils.validateToken(requestHeader)){
            Claims body=jwtUtils.getAllClaimsFromToken(requestHeader);
            Long id= Long.parseLong( body.get("id").toString());
            Optional<UserEntity> optionalUserEntity=userRepository.findById(id);
            if (optionalUserEntity.isEmpty()){
                throw new NotFindException("cant find user",this.getClass().getName());
            }

            if(roleRepository.existsByUrlAvailableAndType(url, optionalUserEntity.get().getRole())){
                tokenHolderService.setter(Long.parseLong(body.get("id").toString()),body.getSubject());
                filterChain.doFilter(request,response);
            }
            else{
                throw  new NotAccessException("you havent access to this url",this.getClass().getName());
            }

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
