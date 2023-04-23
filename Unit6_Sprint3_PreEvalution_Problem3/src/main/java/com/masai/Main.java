package com.masai;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfApp.class);
		
		LibraryService libraryService = ac.getBean(LibraryService.class);
		
		try {
			libraryService.printLibrarianList();
			
			System.out.println("=======================================================");
			
			libraryService.printMemberList();
			
			System.out.println("=======================================================");
			
			libraryService.issueBook(1,2,2);
			System.out.println("Issued Book successfully");
			
			System.out.println("=======================================================");
			
			libraryService.returnBook(1,1,2);
			System.out.println("Return Book successfully");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			((AnnotationConfigApplicationContext)ac).close();
		}

	}
	
}