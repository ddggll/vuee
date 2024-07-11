package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 22457
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int id;
    private String name;
    private String sex;
    private String studentId;
    private String academy;
    private String major;
    private String phone;
    private String department;
    private String email;
    private String cardNumber;
    private String qq;
    private String weiXin;
    private String password;
}
