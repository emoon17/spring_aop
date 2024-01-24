package com.in28minutes.learnspringaop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Around("execution(* com.in28minutes.learnspringaop.aop.business.*.*(..))")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // JoinPoint를 쓰지 않는 이유 : findExecutionTime해당 메소드를 실행시키고 싶기 때문
																			// ProceedingJoinPoint : AspectJ 애스펙트 중 Around 애스팩트를 지원한다	
		
		//Start a Timer -- 1. 이 작업은 execution 해당 메소드가 실행되기 전에 수행하고 
		long startTimeMillis = System.currentTimeMillis();
		// Execute the method - 대상 메소드를 호출해준다.
		Object returnValue = proceedingJoinPoint.proceed();
		//Stop the timer -- 2. 이 작업은 실행이 끝난 후에 수행하게 된다.
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect - {} Method executed in {}ms ", proceedingJoinPoint, executionDuration);
		return returnValue;
	}
}
