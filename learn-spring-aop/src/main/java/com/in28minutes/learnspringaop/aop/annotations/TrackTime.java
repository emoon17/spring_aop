package com.in28minutes.learnspringaop.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 어노테이션을 만든 목적 : 런타임에 사용하고싶고, 이 어노테이션은 메소드 대상으로만 사용하고 싶다.
// 이 어노테이션은 포인트 컷으로도 사용할 수 있다.
//Methods, Runtime
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {

}
