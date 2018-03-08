package com.kgisl.Eventhandler.Eventhandler.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventHandlerAspect {
    //private static final Logger LOGGER = LoggerFactory.getLogger(TodoAspect.class);
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.kgisl.Eventhandler.Eventhandler.service.*.*(..))")
    public void controller() {
    }

    @Pointcut("execution(* com.kgisl.Eventhandler.Eventhandler.service.*.*(..))")
    protected void allMethod() {
    }

    // @Before("execution(* com.kgisl.Eventhandler.Eventhandler..service.*.*(..))")
    // public void beforelog(JoinPoint point) {
    //     LOGGER.info("************* @Before advice called *************");
    //     LOGGER.debug("Class Name :  " + point.getSignature().getDeclaringTypeName());
    //     LOGGER.info("Entering in Method :  " + point.getSignature().getName());
    //     LOGGER.warn("Argumentsttt :  " + Arrays.toString(point.getArgs()));
    // }

    // @AfterReturning(pointcut = "within(@org.springframework.stereotype.Service *)", returning = "result")
    // public void logAfterReturning(JoinPoint joinPoint, Object result) {
    //     LOGGER.info("************* @AfterReturning advice called *************");
    //     LOGGER.info(" ###### Returning for class : {} ; Method : {} ", joinPoint.getTarget().getClass().getName(),
    //             joinPoint.getSignature().getName());
    //     if (result != null) {
    //         LOGGER.info(" ###### with value : {}", result.toString());
    //     } else {
    //         LOGGER.info(" ###### with null as return value.");
    //     }
    // }

    // @AfterThrowing(pointcut = "within(@org.springframework.stereotype.Service *)", throwing = "exception")
    // public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
    //     LOGGER.info("************* @AfterThrowing advice called *************");
    //     LOGGER.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
    //     LOGGER.error("Cause : " + exception);
    // }

    @Around("execution(* com.kgisl.Eventhandler.Eventhandler.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        LOGGER.info("************* @Around advice called *************");

        LOGGER.info("The method "+joinPoint.getSignature().getName()+"() begins with "
                +Arrays.toString(joinPoint.getArgs()));
        try{
            Object result = joinPoint.proceed();
            LOGGER.info("The method "+joinPoint.getSignature().getName()
                    +"() ends with "+result);
            return result;
        }catch(IllegalArgumentException e){
            // LOGGER.error("Illegal argument "+Arrays.toString(joinPoint.getArgs())
            //         +" in "+joinPoint.getSignature().getName()+"()");
            // throw e;
            LOGGER.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

    throw e.getCause();
        }
    }

  

}