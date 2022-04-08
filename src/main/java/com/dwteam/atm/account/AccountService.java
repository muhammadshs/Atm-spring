package com.dwteam.atm.account;

public interface AccountService {
    void save(AccountEntity account);
    void deposit(Double amount);
    void withdraw(Double amount);
    AccountEntity transferAmount(Double amount , String targetAccountNumber);
    AccountEntity getAccount();
    AccountEntity getAccount(String accountNumber);
}
