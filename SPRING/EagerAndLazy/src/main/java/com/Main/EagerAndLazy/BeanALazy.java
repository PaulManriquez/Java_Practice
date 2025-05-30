package com.Main.EagerAndLazy;

import com.Main.Main;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanALazy {

    private static final Logger logger = LoggerFactory.getLogger(BeanALazy.class);

    @PostConstruct
    public void init(){
        logger.info("BEAN A LAZY");
    }

}
