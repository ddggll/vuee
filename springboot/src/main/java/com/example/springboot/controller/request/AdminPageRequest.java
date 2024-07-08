package com.example.springboot.controller.request;

import lombok.Data;

/**
 * @author 22457
 */
@Data
public class AdminPageRequest extends BaseRequest {
    private String name;
    private String phone;
}
