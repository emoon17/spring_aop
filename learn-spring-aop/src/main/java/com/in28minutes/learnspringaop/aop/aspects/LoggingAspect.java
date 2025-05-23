package com.in28minutes.learnspringaop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//1. 설정 클래스 명시 -aop
@Configuration
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//모든 로그 가져오기
	// 2.비즈니스 레이어와 데이터 레이어 빈에서 호출되는 메소드 호출을 인터셉트해야한다. : 포인트 컷으로 정의할 것이다.
	// 3.Pointcut : 언제를 지정 when - 어떤 메소드를 인터셉트할 것인가.
	// execution(* PACKAGE.*.*(..))
	// 메소드 호출 전에 실행할 것이기 때문에 Before
	@Before("com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()") 
	public void LogMethodCallBeforeExecution(JoinPoint joinPoint) { //joinpoint 특정 메소드 실행을 명시 
		//4. Advice : 무엇에 대한 건지 지정 what(어떤 메소드를 대상으로 하는가)
		logger.info("Before Aspect - Method is called - {}", joinPoint); 
	}
	
	@After("com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.businessPackageConfig()") 
	public void LogMethodCallAfterExecution(JoinPoint joinPoint) {  
		logger.info("After Aspect - {} has executed", joinPoint); 
	}
	
	@AfterThrowing(
			pointcut ="com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
			throwing = "exception"
			) 
	public void LogMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {  
		logger.info("AfterThrowing Aspect - {} has thrown an executed", joinPoint, exception); 
	}
	
	@AfterReturning(
			pointcut ="com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.dataPackageConfig()",
			returning = "resultValue"
			) 
	public void LogMethodCallAfterReturningExecution(JoinPoint joinPoint, Object resultValue) {  
		logger.info("@AfterReturning Aspect - {} has {}", joinPoint, resultValue); 
	}
}
