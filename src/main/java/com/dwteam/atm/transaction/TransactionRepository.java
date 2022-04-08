package com.dwteam.atm.transaction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionEntity,Long> {
    List<TransactionEntity> findAllByAccount_User_Id(Long userId);
}
