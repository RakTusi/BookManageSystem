package com.gdpu.common.vo;

public class Result {
    private Integer code;   //返回码，0为成功，-1为失败
    private String msg; //返回信息
    private Object data;         //返回数据
    private Long count;     //分页查询的总记录数（Layui要求）

    public static final Integer SUCCESS_CODE = 0;
    public static final Integer FAILED_CODE = -1;

    private Result() {
    }

    private Result(Integer code, String msg, Object data, Long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    //返回成功信息
    public static Result succeed() {
        return new Result(SUCCESS_CODE, "success", null, null);
    }

    public static Result succeed(String message) {
        return new Result(SUCCESS_CODE, message, null, null);
    }

    public static Result succeed(Object data, Long count) {
        return new Result(SUCCESS_CODE, "success", data, count);
    }

    public static Result succeed(String message, Object data, Long count) {
        return new Result(SUCCESS_CODE, message, data, count);
    }

    //返回失败信息
    public static Result fail() {
        return new Result(FAILED_CODE, "failed", null, null);
    }

    public static Result fail(String message) {
        return new Result(FAILED_CODE, message, null, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
