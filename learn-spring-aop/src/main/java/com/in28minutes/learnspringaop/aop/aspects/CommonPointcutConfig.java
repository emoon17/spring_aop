package com.in28minutes.learnspringaop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.in28minutes.learnspringaop.aop.*.*.*(..))")
	public void businessAndDataPackageConfig() {}

	@Pointcut("execution(* com.in28minutes.learnspringaop.aop.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learnspringaop.aop.data.*.*(..))")
	public void dataPackageConfig() {}
	
	
	//.. bean(*Service* : Service라는 단어가 포함된 빈이라면 인터셉트 대상이 된다.
	@Pointcut("bean(*Service*)") 
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.in28minutes.learnspringaop.aop.annotations.TrackTime)")
	public void trackTimeAnnotation() {}

}
