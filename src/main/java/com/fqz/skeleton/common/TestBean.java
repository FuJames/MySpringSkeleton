package com.fqz.skeleton.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by qianzhong.fu on 2015/6/24.
 */
@Component
public class TestBean {
    private static final long FIXED_RATE = 60*1000L;

    @PostConstruct
    public void sayHello(){
        System.out.println("Hello World !!!");
    }
    @PreDestroy
    public void sayGoodbye(){
        System.out.println("Goodbye World !!!");
    }
    @Scheduled( fixedRate = FIXED_RATE)
    public void sayByTime(){
        System.out.println("Hi World !!!");
    }
}
