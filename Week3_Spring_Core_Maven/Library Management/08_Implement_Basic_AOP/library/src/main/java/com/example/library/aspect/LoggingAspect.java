package com.example.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.library.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("[LOG - BEFORE] Executing: " + joinPoint.getSignature());
    }

    @After("execution(* com.example.library.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("[LOG - AFTER] Executed: " + joinPoint.getSignature());
    }
}