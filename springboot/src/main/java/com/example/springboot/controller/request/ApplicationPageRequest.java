package com.example.springboot.controller.request;


import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 22457
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApplicationPageRequest extends BaseRequest {
    private String username;
    private String phone;
    private String state;
}
