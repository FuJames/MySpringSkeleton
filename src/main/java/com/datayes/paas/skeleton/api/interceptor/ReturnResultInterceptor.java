package com.datayes.paas.skeleton.api.interceptor;

import com.datayes.paas.skeleton.common.Interceptor;
import org.springframework.stereotype.Component;

@Component
public class ReturnResultInterceptor extends Interceptor {

    @Override
    public boolean beforeHandler() {
        return true;
    }
}
