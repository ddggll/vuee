package com.example.springboot.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author 22457
 */
@Data
public class Application {
    private Integer id;
    private String username;
    private String phone;
    private String academy;
    private String number;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date useTime;
    private String site;
    private String equipment;
    private String teacher;
    private String opinion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String teaTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String opTime;
    private String state;
}
