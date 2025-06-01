package com.Main.EagerAndLazy;

import com.Main.EagerToLazyBehavior.BeanALazy;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanEager {

    private static final Logger logger = LoggerFactory.getLogger(BeanEager.class);

    @Autowired
    private BeanLazy myBean;

    @PostConstruct
    public void init(){
        logger.info("IM A EAGER BEAN YOU AUTOMATICALLY SEE ME");
    }
}
