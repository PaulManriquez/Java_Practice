package com.Main.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAspect {

//    @Before("execution (* com.Main.AOP.TargetObject.*(..))")
//    public void before(){
//        System.out.println("================Before do this===============");
//        System.out.println("Clean your hands before greeting to the world");
//        System.out.println("=============================================");
//    }

//    @Before("execution (* com.Main.AOP.TargetObject.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("================Before do this===============");
//        System.out.println("Clean your hands before greeting to the world");
//        System.out.println("Method name:" + joinPoint.getSignature().getName());
//        System.out.println("Object type:"+ joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("Is public:"+ Modifier.isPublic(joinPoint.getSignature().getModifiers()));
//        System.out.println("Arguments:"+ joinPoint.getArgs());
//        System.out.println("=============================================");
//    }

    @Before("PointCutExample.targetObjectMethods()")
    public void before(JoinPoint joinPoint){
        System.out.println("================Before do this===============");
        System.out.println("Clean your hands before greeting to the world");
        System.out.println("Method name:" + joinPoint.getSignature().getName());
        System.out.println("Object type:"+ joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("Is public:"+ Modifier.isPublic(joinPoint.getSignature().getModifiers()));
        System.out.println("Arguments:"+ joinPoint.getArgs());
        System.out.println("=============================================");
    }
}
