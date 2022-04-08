package com.dwteam.atm.user;

import com.dwteam.atm.security.TokenDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;
    private UserMapper mapper;

    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO userDTO){
        userService.registration(mapper.toEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserDTOLogin login){
        TokenDTO tokenDto=userService.login(login.getUserName(),login.getPassWord());
        return ResponseEntity.ok(tokenDto);
    }

}
