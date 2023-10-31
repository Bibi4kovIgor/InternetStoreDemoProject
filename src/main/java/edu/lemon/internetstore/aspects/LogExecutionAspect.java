package edu.lemon.internetstore.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public interface LogExecutionAspect {
    Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable;
}
