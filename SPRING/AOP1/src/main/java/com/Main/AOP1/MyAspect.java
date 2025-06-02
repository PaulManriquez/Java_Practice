package com.Main.AOP1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Component
@Aspect
public class MyAspect {

    //============================ (1) ============================
//    @Before("execution(* com.Main.AOP1.TargetObject.*(..))")
//    public void before(){
//        System.out.println("Before TargetObject:");
//    }

    //============================ (2) ============================
//    @Before("execution(* com.Main.AOP1.TargetObject.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("=== Before TargetObject ===");
//        System.out.println("Method name:" + joinPoint.getSignature().getName());
//        System.out.println("Object type:" + joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("Is public:"+ Modifier.isPublic(joinPoint.getSignature().getModifiers()));
//        System.out.println("Arguments:"+ Arrays.toString(joinPoint.getArgs()));
//
//    }

}
