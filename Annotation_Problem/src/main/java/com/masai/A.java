package com.masai;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class A {

	@Autowired
	private B b;
	
	
	@Autowired
	private List<String> cities;

	@Value("100")
	private int a;

	public void funA() {
		System.out.println("inside funA of A");
		b.funB();
		System.out.println(cities);
		System.out.println(a);
	}
	
	

	@PostConstruct
	public void init() {
		System.out.println("Start the journey....");
	}
	

	@PreDestroy
	public void distroy() {
		System.out.println("End the journey.....");
	}
}
