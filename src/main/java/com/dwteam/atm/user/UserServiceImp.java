package com.dwteam.atm.user;

import com.dwteam.atm.exception.NotFindException;
import com.dwteam.atm.security.JwtUtils;
import com.dwteam.atm.security.TokenDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    private JwtUtils jwtUtils;
    @Override
    public TokenDTO login(String userName, String passWord) {
        String sha3Hex = new DigestUtils("SHA3-256").digestAsHex(passWord);
        Optional<UserEntity> op = userRepository.findByUserNameAndPassWord(userName,sha3Hex);
        if (op.isEmpty()){
            throw new NotFindException("this username not registered",this.getClass().getName());
        }
        TokenDTO tokenDto=new TokenDTO();
        tokenDto.setToken(jwtUtils.doGenerateToken(op.get().getId(),userName));
        return tokenDto;

    }

    @Override
    public void registration(UserEntity user) {
        String sha3Hex = new DigestUtils("SHA3-256").digestAsHex(user.getPassWord());
        user.setPassWord(sha3Hex);
        userRepository.save(user);
    }
}
