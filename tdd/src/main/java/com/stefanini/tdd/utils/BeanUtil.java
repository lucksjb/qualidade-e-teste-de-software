package com.stefanini.tdd.utils;


import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
@Startup
public final class BeanUtil {
    private static Instance<Object> instance;

    @Inject
    public Instance<Object> injectedInstance;

    private BeanUtil() {
    }
    
    @PostConstruct
    void init() {
        BeanUtil.instance = injectedInstance;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return BeanUtil.instance.select(beanClass).get();
    }
}
