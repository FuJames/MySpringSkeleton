package com.datayes.paas.skeleton.common.model;

import com.datayes.paas.skeleton.common.exception.CommonException;

public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(){
        this(ResultType.SUCCESS);
    }

    public Result(ResultType resultType){
        code = resultType.getCode();
        message = resultType.getMessage();
    }

    public Result(CommonException ex){
        code = ex.getErrorType().getCode();
        message = ex.getMessage();
    }
    public Result(Exception ex){
        if(ex instanceof CommonException)
            code = ((CommonException)ex).getErrorType().getCode();
        else
            code = ResultType.INTERNAL_ERROR.getCode();
        message = ex.getMessage();
    }

    public Result(Object data){
        this(ResultType.SUCCESS);
        this.data = data;
    }

    public Result(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
