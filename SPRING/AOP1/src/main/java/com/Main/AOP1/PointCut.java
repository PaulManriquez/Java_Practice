package com.Main.AOP1;

import org.aspectj.lang.annotation.Pointcut;

public class PointCut {
    @Pointcut("execution(* com.Main.AOP1.TargetObject.*(..))")
    public void targetObjectMethods(){}
}
