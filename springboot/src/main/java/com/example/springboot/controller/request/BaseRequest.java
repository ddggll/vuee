package com.example.springboot.controller.request;


import lombok.Data;

/**
 * @author 22457
 */
@Data
public class BaseRequest {
    private Integer page = 1;
    private Integer size = 10;
}
