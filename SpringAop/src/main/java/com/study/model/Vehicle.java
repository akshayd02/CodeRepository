package com.study.model;

public interface Vehicle {

	default void init() {
		System.out.println("Initializing...");
	}
	
	void exec();
}
