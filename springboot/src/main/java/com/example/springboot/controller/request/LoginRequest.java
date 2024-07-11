package com.example.springboot.controller.request;

import lombok.Data;
/**
 * @author 22457
 */
@Data
public class LoginRequest {
    private String studentId;
    private String password;
}
