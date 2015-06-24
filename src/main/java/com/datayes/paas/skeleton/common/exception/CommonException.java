package com.datayes.paas.skeleton.common.exception;


import com.datayes.paas.skeleton.common.model.ResultType;

import java.io.IOException;

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
