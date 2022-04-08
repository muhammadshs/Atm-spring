package com.dwteam.atm.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TokenHolderService {
    private TokenHolder tokenHolder;
    public void setter(Long id,String userName){
        tokenHolder.setId(id);
        tokenHolder.setUserName(userName);
    }
    public Long getId(){
        return tokenHolder.getId();
    }
    public String getUserName(){
        return tokenHolder.getUserName();
    }
}
