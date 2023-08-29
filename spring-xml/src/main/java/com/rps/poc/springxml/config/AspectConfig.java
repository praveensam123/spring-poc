package com.rps.poc.springxml.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectConfig {

    @AfterReturning(pointcut = "execution(* com.rps.poc..*.*(..))", returning = "retVal")
    public void logAfterMethod(JoinPoint joinPoint, Object retVal) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
