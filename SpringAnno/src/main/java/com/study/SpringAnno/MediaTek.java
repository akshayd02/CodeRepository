package com.study.SpringAnno;

import org.springframework.stereotype.Component;

@Component

public class MediaTek implements MobileProcessor {

	public void process() {
		System.out.println("World's second best");
	}

}
