package com.Main.AOP;

import org.aspectj.lang.annotation.Pointcut;


public class PointCutExample {

    @Pointcut("execution (* com.Main.AOP.TargetObject.*(..))")
    public void targetObjectMethods(){}
}
