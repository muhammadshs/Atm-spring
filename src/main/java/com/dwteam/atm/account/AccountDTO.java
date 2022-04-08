package com.dwteam.atm.account;

import com.dwteam.atm.user.UserDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountDTO {

    @NotNull
    private String accountNumber;

    @NotNull
    private Double amount;

    @NotNull
    private UserDTO user;
}
