package com.Main.EagerAndLazy;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanLazy {

    private static final Logger logger = LoggerFactory.getLogger(BeanLazy.class);

    @PostConstruct // Called after the bean is constructed and dependencies are injected
    public void init(){
        logger.info("IF YOU ARE SEEING ME, I WAS CALLED/WIRED BY AN EAGER BEAN");
    }
}
