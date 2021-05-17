package com.study.model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("Car has started");
	}

}
