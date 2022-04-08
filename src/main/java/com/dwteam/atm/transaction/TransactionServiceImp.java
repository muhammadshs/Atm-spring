package com.dwteam.atm.transaction;

import com.dwteam.atm.account.AccountEntity;
import com.dwteam.atm.security.TokenHolderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;
    private TokenHolderService tokenHolderService;

    @Override
    public void save(TransactionEntity transaction) {
        //-------------
        AccountEntity account = new AccountEntity();
        account.setId(tokenHolderService.getId());
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
}
