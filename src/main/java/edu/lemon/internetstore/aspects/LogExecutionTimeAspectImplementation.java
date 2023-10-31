package edu.lemon.internetstore.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspectImplementation implements LogExecutionAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LogExecutionTimeAspectImplementation.class);
    @Override
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long executionTime = System.nanoTime() - start;

        LOG.info(String.format("Method %s was executed in %d ns", joinPoint.getSignature(), executionTime));
        return proceed;
    }
}
