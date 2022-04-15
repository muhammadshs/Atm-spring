package com.dwteam.atm.user;

import lombok.Data;


import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private Long id;


    @Size(min = 6, message = "This field must be completed with at least 6 characters")
    private String userName;


    //@Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8}$", message = "Minimum eight characters, at least one letter, one number and one special character:")
    private String passWord;


    private String displayName;


}
