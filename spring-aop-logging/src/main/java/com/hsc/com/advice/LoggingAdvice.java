package com.hsc.com.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution(* com.hsc.com.*.*.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
                + mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        log.info(className + " : " + methodName + "()" + "Response : "
                + mapper.writeValueAsString(object));
        return object;
    }

}

