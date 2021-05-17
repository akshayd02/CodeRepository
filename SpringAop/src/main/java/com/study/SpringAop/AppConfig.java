package com.study.SpringAop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.study.aspect.LoggingAspect;
import com.study.model.Bike;
import com.study.model.Car;

@Configuration
@ComponentScan(basePackageClasses = {LoggingAspect.class,Bike.class})
public class AppConfig {
	
	@Bean
	public Car getCar() {
		return new Car();
	}
}
