package com.dwteam.atm.account;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
    private AccountService accountService;
    private AccountMapper accountMapper;

    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody AccountDTO account ){
        accountService.save(accountMapper.toEntity(account));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
