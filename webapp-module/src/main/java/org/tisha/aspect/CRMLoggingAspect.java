package org.tisha.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Tsikhan Kuprevich
 * @since 7/26/2017
 */
@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Pointcut("execution(* org.tisha.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* org.tisha.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* org.tisha.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("=====>> @Before: About to call method: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object arg : args) {
                logger.info("=====>> argument: " + arg);
            }
        }

    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("=====>> @AfterReturning: After returned from method: " + joinPoint.getSignature().toShortString());

        logger.info("=====>> result: " + result);
    }

}
