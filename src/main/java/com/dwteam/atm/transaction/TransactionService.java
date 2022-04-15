package com.dwteam.atm.transaction;

import java.util.List;

public interface TransactionService {
    void saveInThisAccount(TransactionEntity transaction);
    List<TransactionEntity> listLast10Transaction();
    void save(TransactionEntity transaction);

}
