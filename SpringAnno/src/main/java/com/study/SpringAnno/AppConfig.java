package com.study.SpringAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.study.SpringAnno"})
public class AppConfig {

	/*
	 * @Bean public Samsung getSamsung() { return new Samsung(); }
	 * 
	 * @Bean public MobileProcessor getProcessor() { return new Snapdragon(); }
	 */
}
