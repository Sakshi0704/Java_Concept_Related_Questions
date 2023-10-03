package com.ui;
import java.util.Scanner;

public class UIEmployee {

	public static void manuEmmployee() {
		System.out.println("Select your choice from below");
		System.out.println("0. To Exit from Application");
		System.out.println("1. To Add Employee into record");
		System.out.println("2. To Retrive Employee With Id");
		System.out.println("3. Get All Employee");
		System.out.println("4. To Delete A Employee with Id");
		System.out.println("5. Give Bonus to Employee");
	}
	
	public static void main(String args[]) {
		
		Scanner sr = new Scanner(System.in);
		String choice = "0";
		
		UIEmployeeFunction em = new UIEmployeeFunction();
		do {
			manuEmmployee();
			System.out.print("Enter your choice ");
			choice = sr.next();
			switch(choice) {
				case "1": 
						em.registerEmployee(sr);
						break;
				case "2" :
						em.getEmployeeById(sr);
						break;
				case "3" :
					em.getAllEmployee();
					 break;
				case "4" :
					em.deleteEmployeeById(sr);
					  break;
				case "5" :
					  em.giveBonusToEmployee(sr);
						break;
				case "0" :
					   System.out.println("Thank you for visiting");
						break;
				default: System.out.println("Please enter the vaild choice");
						break;
					
			}
		}while(!choice.equals("0"));
	}
	
	
}
