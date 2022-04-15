package com.dwteam.atm.security;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
    Optional<Role> findByUrlAvailable(String url);
    Boolean existsByUrlAvailableAndType(String url,RoleTypeEnum type);
}
