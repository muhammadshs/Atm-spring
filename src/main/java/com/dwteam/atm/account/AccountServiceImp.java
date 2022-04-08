package com.dwteam.atm.account;

import com.dwteam.atm.exception.NotFindException;
import com.dwteam.atm.security.TokenHolderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService{
    private AccountRepository accountRepository;
    private TokenHolderService tokenHolderService;
    @Override
    public void save(AccountEntity account) {
        accountRepository.save(account);
    }

    @Override
    public void deposit(Double amount) {
        Optional<AccountEntity> op=accountRepository.findByUser_Id(tokenHolderService.getId());
        if(op.isEmpty()){
            throw new NotFindException("you havent account",this.getClass().getName());
        }
        AccountEntity account=op.get();
        account.setAmount(account.getAmount()+amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(Double amount) {
        Optional<AccountEntity> op=accountRepository.findByUser_Id(tokenHolderService.getId());
        if(op.isEmpty()){
            throw new NotFindException("you havent account",this.getClass().getName());
        }
        AccountEntity account=op.get();
        account.setAmount(account.getAmount()-amount);
        accountRepository.save(account);
    }

    @Override
    public AccountEntity transferAmount(Double amount, String targetAccountNumber) {
        Optional<AccountEntity> op=accountRepository.findByAccountNumber(targetAccountNumber);
        if(op.isEmpty()){
            throw new NotFindException("cant find account with this account number",this.getClass().getName());
        }
        AccountEntity account=op.get();
        withdraw(amount);
        account.setAmount(account.getAmount()+amount);
        return account;
    }

    @Override
    public AccountEntity getAccount() {
        Optional<AccountEntity> op=accountRepository.findByUser_Id(tokenHolderService.getId());
        if(op.isEmpty()){
            throw new NotFindException("you havent account",this.getClass().getName());
        }
        return op.get();
    }

    @Override
    public AccountEntity getAccount(String accountNumber) {
        Optional<AccountEntity> op=accountRepository.findByAccountNumber(accountNumber);
        if(op.isEmpty()){
            throw new NotFindException("cant find account with this account number",this.getClass().getName());
        }
        return op.get();
    }

}
