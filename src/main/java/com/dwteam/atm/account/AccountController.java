package com.dwteam.atm.account;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
    private AccountService accountService;
    private AccountMapper accountMapper;

    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody AccountDTO account , @RequestParam Long userId){
        accountService.save(accountMapper.toEntity(account),userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam Long accountId){
        accountService.delete(accountId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
