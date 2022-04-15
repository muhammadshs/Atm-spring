package com.dwteam.atm.transaction;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/transaction")
public class TransactionController {
    private TransactionService transactionService;
    private TransactionMapper transactionMapper;
    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody TransactionDTO transactionDTO){

        transactionService.saveInThisAccount(transactionMapper.toEntity(transactionDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/last10transaction")
    public ResponseEntity<List<TransactionDTO>> last10Transaction(){
        List<TransactionDTO> list=transactionMapper.toListDTO(transactionService.listLast10Transaction());
        return ResponseEntity.ok(list);
    }
}
