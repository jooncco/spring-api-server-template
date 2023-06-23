package com.templates.springapiserver.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class SampleAspect {

    @Around("execution(* com.templates.springapiserver..*.HealthController.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();
        try {
            log.info((String) retVal);
        } catch (Exception e) {
            log.info("model");
        }
        return retVal;
    }
}
