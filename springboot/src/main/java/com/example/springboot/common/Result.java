package com.example.springboot.common;

import lombok.Data;

@Data
public class Result {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private String code;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(FAIL);
        result.setMsg(msg);
        return result;
    }
}
