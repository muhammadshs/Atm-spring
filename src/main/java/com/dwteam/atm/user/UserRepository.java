package com.dwteam.atm.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Long> {
    Optional<UserEntity> findByUserNameAndPassWord(String userName,String passWord);
    boolean existsByUserNameAndPassWord(String userName,String passWord);
    boolean existsByUserName(String userName);
}
