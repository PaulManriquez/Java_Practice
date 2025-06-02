package com.Main.AOP1;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Component
@Aspect
@Order(0)
public class MyAspectOrder0 {

    @Before("execution(* com.Main.AOP1.TargetObject.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("=== MyAspectOrder0 is executed first  ===");
    }

}
