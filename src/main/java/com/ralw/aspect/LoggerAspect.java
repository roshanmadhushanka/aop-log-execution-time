package com.ralw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author roshanalwis on 9/15/18
 */

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(logExecutionTime)")
    public void callAt(LogExecutionTime logExecutionTime) {}

    @Around(value = "callAt(logExecutionTime)", argNames = "joinPoint,logExecutionTime")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        System.out.println(logExecutionTime.isEnabled());
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}
