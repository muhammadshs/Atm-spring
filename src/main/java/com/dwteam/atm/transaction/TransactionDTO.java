package com.dwteam.atm.transaction;

import com.dwteam.atm.enumc.TransactionTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class TransactionDTO {
    @NotNull
    private TransactionTypeEnum type;

    @NotNull
    private Double amount;
}
