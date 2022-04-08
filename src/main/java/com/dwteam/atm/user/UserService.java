package com.dwteam.atm.user;

import com.dwteam.atm.security.TokenDTO;

public interface UserService {
    TokenDTO login(String userName , String passWord);
    void registration(UserEntity user);
}
