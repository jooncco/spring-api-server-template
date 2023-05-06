package com.templates.springapiserverasync.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectComponent {

    @Around("execution(* com.templates.springapiserverasync..*.HealthController.*(..))")
    public Object callTest(ProceedingJoinPoint pjp) throws Throwable {
        log.info("<--- TestClass:callTest");
        Object retVal = pjp.proceed(); // 메서드 호출 자체를 감쌈
        try {
            log.info((String) retVal);
        } catch (Exception e) {
            log.info("model");
        }
        log.info("TestClass:callTest -->");
        return retVal;
    }
}
