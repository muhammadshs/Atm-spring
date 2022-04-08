package com.dwteam.atm.account;

import com.dwteam.atm.base.GenericMapper;
import com.dwteam.atm.user.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface AccountMapper extends GenericMapper<AccountEntity,AccountDTO> {
}
