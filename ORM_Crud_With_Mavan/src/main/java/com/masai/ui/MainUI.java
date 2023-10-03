package com.masai.ui;

import java.util.*;

public class MainUI {
	
	public static void Manu() {
		System.out.println("Select your choice from above option");
		System.out.println("0. Exits from application");
		System.out.println("1. Retrive Perticuler Student By Id");
		System.out.println("2. Save Student By Id");
		System.out.println("3. Update Student Level By Id");
	}
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		String choice = null;
		StudentUI empUI = new StudentUI();
		do{
			Manu();
			System.out.print("Enter Your Choice : ");
			choice = sr.next();
			switch(choice) {
			case "0" :
				 	System.out.println("Thank you for visiting");
				 	break;
			case "1" : 
					empUI.findStudentById(sr);
					break;
			case "2" :
					empUI.saveStudent(sr);
					break;
			case "3" :
					empUI.updateStudentLevel(sr);
					break;
			default : System.out.println("Please enter the valid name");
					break;
					
			}
			
		}while(!choice.equals("0"));
		
		
	}
}
