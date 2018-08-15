package com.fqz.skeleton.exception;


import com.fqz.skeleton.model.ResultType;

public class CommonException extends Exception {

    private ResultType errorType;

    public CommonException(ResultType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CommonException(String message){
        super(message);
        this.errorType = ResultType.CUSTOM_ERROR;
    }
    public CommonException(ResultType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
    public ResultType getErrorType() {
        return errorType;
    }

    public void setErrorType(ResultType errorType) {
        this.errorType = errorType;
    }

}
