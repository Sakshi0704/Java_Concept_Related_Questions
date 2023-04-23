package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
		
		A a = ctx.getBean("a",A.class);
		
		a.funA();
		
		A a1 = ctx.getBean("a",A.class);
		a1.funA();
		
		((AnnotationConfigApplicationContext)ctx).close();
	
		
		
		
		
	}
	
}
