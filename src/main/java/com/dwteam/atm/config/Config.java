package com.dwteam.atm.config;

import com.dwteam.atm.security.TokenHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class Config {
    @Bean
    @RequestScope
    public TokenHolder getTokenHolder() {
        return new TokenHolder();
    }
}
