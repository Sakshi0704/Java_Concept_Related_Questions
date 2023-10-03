package UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Entity.Employee;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;

public class UIMain {
	
	private EmployeeService s1;
			
	{
		
		s1=new EmployeeServiceImpl();
	}
	
	public void addEmployeeUI(Scanner sc) {
		System.out.print("Enter employee id ");
		String eid = sc.next();
		
		System.out.print("Enter employee name ");
		String name = sc.next();
		
		System.out.print("Enter salary ");
		double salary = sc.nextDouble();
		
		System.out.print("Enter joining data ");
		LocalDate joining_Date = LocalDate.parse(sc.next());
		System.out.println(joining_Date);
		Employee emp1=new Employee(eid,name,salary,joining_Date);
		System.out.println(s1.addEmployee(emp1));
		
		
	}
	public void updateEmployeeUI(Scanner sc) {
		System.out.print("Enter employee id ");
		String eid = sc.next();
		
		System.out.print("Enter employee name ");
		String name = sc.next();
		
		System.out.println("Enter salary ");
		double salary = sc.nextDouble();
		
//		System.out.print("Enter joining data ");
//		LocalDate joining_Date = LocalDate.parse(sc.next());
		Employee emp1=new Employee();
		emp1.setName(name);
		emp1.setSalary(salary);
		System.out.println(s1.updateEmployee(emp1,eid));
	}
	public void viewEmployeeUI(Scanner sc) {
		System.out.print("Enter employee id ");
		String eid = sc.next();
		
		Employee emp = s1.viewEmployee(eid);
		
		if(emp!=null) {
			System.out.println(emp);
			//dekna hai ki by default toString call hoga ki nahi
			
		}
		
	}
	public void deleteStudentUI(Scanner sc) {
		System.out.print("Enter employee id ");
		String eid = sc.next();
		
		
		System.out.println(s1.deleteEmployee(eid));
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UIMain u1=new UIMain();
		int choice = 0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee By Joining Data Range");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					u1.addEmployeeUI(sc);
					break;
				case 2: 
					u1.viewEmployeeUI(sc);
					break;
				case 3: 
					u1.updateEmployeeUI(sc);
					break;
				case 4: 
					u1.deleteStudentUI(sc);
					break;
				case 5: 
					 //searchEmployeeByJoiningDateRangeUI(sc);
					break;
				case 0:
					System.out.println("Thanks for visiting! Byee Byee");
					break;
					
				default: 
					System.out.println("Invalid choice or selection please try again");
			}
			
		}while(choice!=0);
		
	   sc.close();	
	}

}


