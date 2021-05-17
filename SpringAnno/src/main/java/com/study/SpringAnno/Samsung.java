package com.study.SpringAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Samsung {

	@Autowired
	@Qualifier("snapdragon")
	MobileProcessor cpu;
	
	public void config() {
		System.out.println("Octa core, 8GB, 16 MP Camera");
		//cpu.process();
	}
}
