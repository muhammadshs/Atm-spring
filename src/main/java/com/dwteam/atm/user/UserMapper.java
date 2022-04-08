package com.dwteam.atm.user;

import com.dwteam.atm.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserEntity,UserDTO> {

}
