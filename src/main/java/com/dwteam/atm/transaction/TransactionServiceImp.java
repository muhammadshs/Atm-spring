package com.dwteam.atm.transaction;

import com.dwteam.atm.account.AccountEntity;
import com.dwteam.atm.account.AccountRepository;
import com.dwteam.atm.exception.NotFindException;
import com.dwteam.atm.security.TokenHolderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;
    private TokenHolderService tokenHolderService;
    private AccountRepository accountRepository;

    @Override
    public void saveInThisAccount(TransactionEntity transaction) {
        //-------------
        System.out.println(tokenHolderService.getId());
        Optional<AccountEntity> op =accountRepository.findByUser_Id(tokenHolderService.getId());
        if(op.isEmpty()){
            throw new NotFindException("cant find this account",this.getClass().getName());
        }
        AccountEntity account=op.get();
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionEntity> listLast10Transaction() {
        List<TransactionEntity> listAll = transactionRepository.findAllByAccount_User_Id(tokenHolderService.getId());
        List<TransactionEntity> transactionEntities = new ArrayList<>();
        for (int i = listAll.size() - 1; i > listAll.size() - 11; i--) {
            transactionEntities.add(listAll.get(i));
        }
        return transactionEntities;
    }

    @Override
    public void save(TransactionEntity transaction) {
        transactionRepository.save(transaction);
    }

}
