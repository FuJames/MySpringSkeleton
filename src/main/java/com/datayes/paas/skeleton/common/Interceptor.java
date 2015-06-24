package com.datayes.paas.skeleton.common;

import com.datayes.paas.skeleton.common.model.Result;
import com.datayes.paas.skeleton.common.model.ResultType;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class Interceptor {
    public abstract boolean beforeHandler();
    public Result handler(ProceedingJoinPoint pjp){
        try {
            if(beforeHandler()){
                Object data = pjp.proceed();
                return new Result(data);
            }else return new Result(ResultType.SERVER_REJECTED);

        } catch (Throwable throwable) {
            if(throwable instanceof Exception)
                return new Result((Exception)throwable);
            else
                return new Result(ResultType.INTERNAL_ERROR);
        }
    }
}
