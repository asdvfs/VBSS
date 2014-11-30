package com.ap.base.support;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class EntityInterceptor {
 
	
	public void test(JoinPoint jp){
		
		System.out.println("---------------"+jp.getTarget());
		System.out.println("---------------"+jp.getStaticPart().getKind());
	}
	
}
