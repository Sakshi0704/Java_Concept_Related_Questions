package com.masai;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LibraryService {

		@Autowired
		private Map<Librarian, List<Book>> bookMap; // inject 3 entries with valid details
		@Autowired
	    private List<Librarian> librarianList; // inject a list of 5 Librarian objects
		@Autowired
	    private List<Member> memberList; // inject a list of 7 Member objects

	   
	        // print all the librarians and their associated book details from the bookMap
//	    	for(Map.Entry<Librarian, List<Book>> entries : bookMap.entrySet()) {
//	    		
//	    	}
		 public void printBookMap() {	
	    	bookMap.forEach((k,v) ->{
	    		System.out.println(k);
	    		v.forEach(System.out::println);
	    	});
	    	
	    }

	    public void printLibrarianList() {
	        // sort the list of librarians according to the decreasing order of the noOfBooksIssued
	        // if noOfBooksIssued are the same, then sort by age
	        // print all the sorted Librarian details
	    	
	    	
	    	librarianList.sort((a,b)->{
	    		if(a.getNoOfBooksIssued()==b.getNoOfBooksIssued()) {
	    			return a.getAge() - b.getAge();
	    		}
	    		else {
	    			return b.getNoOfBooksIssued() - a.getNoOfBooksIssued();
	    		}
	    	});
	    	
	    	librarianList.forEach(System.out::println);
	    }

	    public void printMemberList() {
	        // sort the list of members according to the decreasing order of the noOfBooksBorrowed
	        // if noOfBooksBorrowed are the same, then sort by age
	        // print all the sorted Member details

	    	memberList.sort((a,b)->{
	    		if(a.getNoOfBooksBorrowed()==b.getNoOfBooksBorrowed()) {
	    			return a.getAge() - b.getAge();
	    		}
	    		else {
	    			return b.getNoOfBooksBorrowed() - a.getNoOfBooksBorrowed();
	    		}
	    	});
	    	
	    	memberList.forEach(System.out::println);
	    	
	    }

	    public void issueBook(int librarianId, int memberId, int bookId) {
	        // Find the Librarian, Member, and Book objects by their respective IDs
	        // Check if the book is available and the member can borrow books (based on a borrowing limit)
	        // Update the book's availability, the librarian's noOfBooksIssued, and the member's noOfBooksBorrowed
	        // Add the issued book to the bookMap
	    	
	    	
	    	Librarian librarian = librarianList.stream().filter(l -> l.getId() == librarianId).findFirst().orElse(null);
	    	
	    	Member member = memberList.stream().filter(l -> l.getId() == memberId).findFirst().orElse(null);
	    	
	    	Book book = null;
	    	List<Book> bookList = null;
	    	
	    	for(Map.Entry<Librarian, List<Book>> map : bookMap.entrySet()) {
	    		   book = map.getValue().stream().filter(l -> l.getId() == bookId).findFirst().orElse(null);
	    	}
	    	
	    	
	    	if(book==null || member== null || librarian==null) {
	    		throw new RuntimeException("Atribute data is not availabe");
	    	}
	    	
	    	if(book.isAvailable()) {
	    		if(member.getNoOfBooksBorrowed()<=3) {
	    			
	    			bookList = bookMap.get(librarian);
	    			member.setNoOfBooksBorrowed( member.getNoOfBooksBorrowed() + 1);
	    			book.setAvailable(false);
	    			bookList.add(book);
	    			librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued() + 1);
	    			 
	    			bookMap.put(librarian, bookList);
	    		
	    			
	    		}else {
	    			throw new RuntimeException(" Member already borrowed more then 3 books ");
	    		}
	    	
	    	}else {
    			throw new RuntimeException(" book is already borrowed by some other person ");
    		}
	    }

	    public void returnBook(int librarianId, int memberId, int bookId) {
	        // Find the Librarian, Member, and Book objects by their respective IDs
	        // Check if the book is currently borrowed by the member
	        // Update the book's availability, the librarian's noOfBooksIssued, and the member's noOfBooksBorrowed
	        // Remove the returned book from the bookMap
	    	
	    	Librarian librarian = librarianList.stream().filter(l -> l.getId() == librarianId).findFirst().orElse(null);
	    	
	    	Member member = memberList.stream().filter(l -> l.getId() == memberId).findFirst().orElse(null);
	    	
	    	Book book = null;
	    	List<Book> bookList = null;
	    	
	    	for(Map.Entry<Librarian, List<Book>> map : bookMap.entrySet()) {
	    		   book = map.getValue().stream().filter(l -> l.getId() == bookId).findFirst().orElse(null);
	    	}
	    	
	    	if(book==null || member== null || librarian==null) {
	    		throw new RuntimeException("Atribute data is not availabe");
	    	}
	    	
	    	if(!book.isAvailable()) {
	    			bookList = bookMap.get(librarian);
	    			 bookList.remove(book);
	    			 
	    			book.setAvailable(true);
	    			member.setNoOfBooksBorrowed( member.getNoOfBooksBorrowed() - 1);
	    			librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued() - 1);
	    			 
	    			bookMap.put(librarian, bookList);
	    	
	    	}else {
    			throw new RuntimeException(" book is not borrowed by some other person ");
    		}
	    
	    }

	
}
