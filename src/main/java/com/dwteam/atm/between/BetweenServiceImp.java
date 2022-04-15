package com.dwteam.atm.between;

import com.dwteam.atm.account.AccountEntity;
import com.dwteam.atm.account.AccountService;
import com.dwteam.atm.enumc.TransactionTypeEnum;
import com.dwteam.atm.transaction.TransactionEntity;
import com.dwteam.atm.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
@Transactional
@Service
@AllArgsConstructor
public class BetweenServiceImp implements BetweenService {
    private AccountService accountService;
    private TransactionService transactionService;
    @Override
    public void withDraw(Double amount) {
        accountService.withdraw(amount);
        TransactionEntity transaction=new TransactionEntity();
        transaction.setAmount(amount);
        transaction.setType(TransactionTypeEnum.Withdraw);
        transactionService.saveInThisAccount(transaction);
    }

    @Override
    public void deposit(Double amount) {
        accountService.deposit(amount);
        TransactionEntity transaction=new TransactionEntity();
        transaction.setAmount(amount);
        transaction.setType(TransactionTypeEnum.Deposit);
        transactionService.saveInThisAccount(transaction);
    }

    @Override
    public void transferAmount(Double amount, String targetAccountNumber) {
        AccountEntity account=accountService.transferAmount(amount,targetAccountNumber);
        TransactionEntity transaction=new TransactionEntity();
        transaction.setAmount(amount);
        transaction.setType(TransactionTypeEnum.Withdraw);
        transaction.setAccount(accountService.getAccount());
        transactionService.save(transaction);
        TransactionEntity transaction2=new TransactionEntity();
        transaction2.setAmount(amount);
        transaction2.setType(TransactionTypeEnum.Deposit);
        transaction2.setAccount(account);
        transactionService.save(transaction2);
    }
}
