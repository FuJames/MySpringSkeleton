package com.fqz.skeleton.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config implements InitializingBean {
    private static Config config;

    @Value("${skeleton.value1}")
    private String value1;

    @Value("${skeleton.value2}")
    private String value2;

    @Value("${skeleton.debug}")
    private boolean debug;

    @Value("${skeleton.max.cache.size}")
    private int maxCacheSize;

    @Value("${skeleton.cache.expire}")
    private int cacheExpire;

    @Override
    public void afterPropertiesSet() throws Exception {
        config = this;
    }

    public static String getValue1() {
        return config.value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public static String getValue2() {
        return config.value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public static boolean isDebug() {
        return config.debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public static int getMaxCacheSize() {
        return config.maxCacheSize;
    }

    public void setMaxCacheSize(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    public static int getCacheExpire() {
        return config.cacheExpire;
    }

    public void setCacheExpire(int cacheExpire) {
        this.cacheExpire = cacheExpire;
    }
}
