package com.study.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {

	@After("execution(public void exec())")
	public void log() {
		System.out.println("**********Generating logs**********");
	}
	
	
	public void pointcut() {}
}
