package com.dwteam.atm.account;

import com.dwteam.atm.base.BaseEntity;
import com.dwteam.atm.user.UserEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Audited
@Table(name = "tbl_account")
public class AccountEntity extends BaseEntity {

    @NotNull
    @Size(min = 16, message = "This field must be completed with 16 characters")
    @Column(name = "account_number",unique = true)
    private String accountNumber;

    @NotNull
    @Column(name = "amount",
            columnDefinition = "double default 50")
    private Double amount;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
