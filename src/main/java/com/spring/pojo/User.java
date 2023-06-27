package com.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private String gender; //性别 , 男, 女
    private String email;
    private String phone;
    private String tag;
    private int postnumbers;
}
