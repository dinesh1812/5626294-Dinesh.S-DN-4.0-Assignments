package com.example.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.example.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        Object result = joinPoint.proceed();

        long end = System.nanoTime();

        System.out.println("[LOG] " + joinPoint.getSignature() +
                " executed in " + (end - start)/1_000_000.0 + " ms");

        return result;
    }

}
