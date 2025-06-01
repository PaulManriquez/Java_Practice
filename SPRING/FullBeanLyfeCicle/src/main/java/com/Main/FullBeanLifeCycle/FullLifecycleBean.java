package com.Main.FullBeanLifeCycle;

import com.Main.Main;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FullLifecycleBean implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(FullLifecycleBean.class);

    public FullLifecycleBean() {
        System.out.println("1 Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2 BeanNameAware: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        System.out.println("3 ApplicationContextAware set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("4 @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("5 afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("6 @PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("7 destroy (DisposableBean)");
    }
}
