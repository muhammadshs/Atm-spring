package com.dwteam.atm.between;

public interface BetweenService {
    void withDraw(Double amount);
    void deposit(Double amount);
    void transferAmount(Double amount,String targetAccountNumber);
}
