package com.Main.FullBeanLifeCycle;

import com.Main.Main;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("IM_BEAN2_EXAMPLE")
public class FullLifecycleBean2 implements
        BeanNameAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(FullLifecycleBean2.class);


    public FullLifecycleBean2() {
        System.out.println("1Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2 BeanNameAware: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("3 ApplicationContextAware: context set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("4 @PostConstruct");
    }

    public void init() {
        System.out.println("5 init(): custom init method (not called unless configured)");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("6 InitializingBean: afterPropertiesSet()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("7 @PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("8 DisposableBean: destroy()");
    }
}
