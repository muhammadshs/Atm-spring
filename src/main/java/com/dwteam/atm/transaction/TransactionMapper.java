package com.dwteam.atm.transaction;

import com.dwteam.atm.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<TransactionEntity,TransactionDTO> {

}
