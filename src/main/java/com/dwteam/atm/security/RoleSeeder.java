package com.dwteam.atm.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class RoleSeeder implements ApplicationRunner {
    private RoleRepository roleRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role=new Role();
        role.setType(RoleTypeEnum.Admin);
        role.setUrlAvailable("/user/delete");
        roleRepository.save(role);
        Role role2=new Role();
        role2.setType(RoleTypeEnum.User);
        role2.setUrlAvailable("/user/login");
        roleRepository.save(role2);
    }
}
