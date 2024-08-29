package com.example.springboot.controller.request;


import lombok.Data;

/**
 * @author 22457
 */
@Data
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
