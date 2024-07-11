package com.example.springboot.controller.dto;

import lombok.Data;

/**
 * @author 22457
 */
/*返回基本登录基本信息*/
@Data
public class LoginDTO {
    private Integer id;
    private String name;
    private String phone;
    private String department;
}
