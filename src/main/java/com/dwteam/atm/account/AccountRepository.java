package com.dwteam.atm.account;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<AccountEntity,Long> {
    Optional<AccountEntity> findByUser_Id(Long userId);
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
