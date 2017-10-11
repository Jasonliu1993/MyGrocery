package com.grocery.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Jason on 10/10/2017.
 */

@Aspect
@Component
public class LoggingMessage {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.grocery.annotation.LogAnnotation)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info(proceedingJoinPoint.getSignature().getDeclaringTypeName());
    }

}
