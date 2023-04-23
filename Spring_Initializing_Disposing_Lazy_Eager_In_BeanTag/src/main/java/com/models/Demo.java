package com.models;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {

	public static void main(String arg[]) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//ApplicationContext ac = new FileSystemXmlApplicationContext(foldername/packagename/filename); 
		// this used when our xml file of spring container will be some another path instend of inside src...
		
		A aobj = ac.getBean("a1",A.class); 
		// so when you get the object of class A then spring Container will throw init method 
		//as well as after inject the all dependancy of class A
		
		aobj.insertStudentRecord();
		
		ClassPathXmlApplicationContext ctx2 = (ClassPathXmlApplicationContext) ac; 
		// need to down cast because ClassPathXmlApplicationContext class have close method to close the spring -container
		
		ctx2.close(); 
		// so when you close the spring Container then before closing 
		//it will throw the destroy-method (tearDown method) of class A...
	
		
	}
	
}
