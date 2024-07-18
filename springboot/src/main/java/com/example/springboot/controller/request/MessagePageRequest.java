package com.example.springboot.controller.request;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 22457
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessagePageRequest extends BaseRequest{
    private String headline;
    private String type;
    private String state;
}
