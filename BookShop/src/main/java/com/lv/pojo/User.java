package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;

    private String uname;

    private String password;

    private String gender;

    private String phone;

    private String email;

    private String adress;

    
}