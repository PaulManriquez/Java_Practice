package com.Main.EagerToLazyBehavior;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component//Now im a bean
@Lazy//By default a bean is EAGER, the anotation do not exist
//But you can set as @Lazy(false)
//@Lazy//Lazy is not wired automatically
//@Eager //Beans are eagerly loaded by default in Spring unless annotated with @Lazy
public class BeanALazy {

    private static final Logger logger = LoggerFactory.getLogger(BeanALazy.class);

    @PostConstruct
    public void init(){
        logger.info("IF IM A EAGER BEAN, YOU ARE SEEING ME");
    }

}
