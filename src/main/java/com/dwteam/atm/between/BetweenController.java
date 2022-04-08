package com.dwteam.atm.between;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BetweenController {
    private BetweenService betweenService;
    @PostMapping(value = "/deposit")
    public ResponseEntity<Void> deposit(@RequestParam Double amount){
            betweenService.deposit(amount);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/withdraw")
    public ResponseEntity<Void> withDraw(@RequestParam Double amount){
        betweenService.withDraw(amount);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/transfer/amount")
    public ResponseEntity<Void> transferAmount(@RequestParam Double amount ,@RequestParam String accountNumber){
        betweenService.transferAmount(amount,accountNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
