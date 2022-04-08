package com.dwteam.atm.transaction;

import java.util.List;

public interface TransactionService {
    void save(TransactionEntity transaction);
    List<TransactionEntity> listLast10Transaction();

}
