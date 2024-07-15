package com.example.springboot.controller.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 22457
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPageRequest extends BaseRequest{
    private String name ;
    private String phone;
}
