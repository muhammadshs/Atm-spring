package com.dwteam.atm.security;

import com.dwteam.atm.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_roles")
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleTypeEnum type;

    @Column(name = "url_available")
    private String urlAvailable;
}
