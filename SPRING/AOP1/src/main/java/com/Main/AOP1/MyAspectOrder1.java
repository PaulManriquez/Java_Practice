package com.Main.AOP1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component

@Aspect
@Order(1)
public class MyAspectOrder1 {

    //@Before("execution(* com.Main.AOP1.TargetObject.*(..))")
    @Before("PointCut.targetObjectMethods()")
    public void before(JoinPoint joinPoint){
        System.out.println("=== MyAspectOrder1 is executed second  ===");
    }

}