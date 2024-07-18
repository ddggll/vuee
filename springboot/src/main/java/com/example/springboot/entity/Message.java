package com.example.springboot.entity;

import lombok.Data;

/**
 * @author 22457
 */
@Data
public class Message {
    private Integer id;
    private String content;
    private String time;
    private String address;
    private String state;
    private String headline;
    private String type;

}
