package com.masai;

class Myexception extends Exception{
	public Myexception(String message) {
		super(message);
	}
	
}

class MyClass{
	public void test() throws Myexception {
		try {
			System.out.print("One");
			throw new Myexception("Exception.......");
		}finally{
			System.out.print("Two");
		}
	}
}


class B extends MyClass{
	
	public void test() {
		try {
			System.out.print("One");
		}finally{
			System.out.print("Two");
		}
	}

	@Overloading
	public void test(int x){
		return;
	}
}



public class A {
	
	public void calculate(int n) throws Myexception  {
		if(n<5) {
			throw new Myexception("give the valid number");
		}
	}
	
	public static void main(String args[]) {
		int n = 5;
		try {
			new A().calculate(n);
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyClass m = new B();
		try {
			m.test();
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
