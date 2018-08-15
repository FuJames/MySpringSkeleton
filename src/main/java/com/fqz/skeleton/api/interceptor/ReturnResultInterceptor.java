package com.fqz.skeleton.api.interceptor;

import com.fqz.skeleton.common.Interceptor;
import org.springframework.stereotype.Component;

@Component
public class ReturnResultInterceptor extends Interceptor {

    @Override
    public boolean beforeHandler() {
        return true;
    }
}
