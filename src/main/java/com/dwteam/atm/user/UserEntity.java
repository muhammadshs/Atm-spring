package com.dwteam.atm.user;

import com.dwteam.atm.account.AccountEntity;
import com.dwteam.atm.base.BaseEntity;
import com.dwteam.atm.security.RoleTypeEnum;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Audited
@Data
public class UserEntity extends BaseEntity {

    @NotNull
    @Size(min = 6, message = "This field must be completed with at least 6 characters")
    @Column(name = "username", unique = true)
    private String userName;

    @NotNull
    // @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message = "Minimum eight characters, at least one letter, one number and one special character:")
    @Column(name = "password")
    private String passWord;

    @NotNull
    @Column(name = "display_name")
    private String displayName;

    @Column(columnDefinition = "varchar(255) default 'User'")
    @Enumerated(EnumType.STRING)
    private RoleTypeEnum role;
}
