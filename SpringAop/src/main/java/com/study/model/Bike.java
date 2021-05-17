package com.study.model;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("Bike has started");
	}

}
