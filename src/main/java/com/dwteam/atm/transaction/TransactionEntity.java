package com.dwteam.atm.transaction;

import com.dwteam.atm.account.AccountEntity;
import com.dwteam.atm.base.BaseEntity;
import com.dwteam.atm.enumc.TransactionTypeEnum;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Audited
@Table(name = "tbl_transaction")
public class TransactionEntity extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account")
    private AccountEntity account;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionTypeEnum type;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @Column(name = "code")
    private Long transactionCode;

}
