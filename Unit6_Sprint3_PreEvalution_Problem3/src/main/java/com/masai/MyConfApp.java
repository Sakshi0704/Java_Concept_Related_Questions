package com.masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class MyConfApp {


	@Bean
	public Map<Librarian, List<Book>> bookMap() {

		Librarian l1 = new Librarian(1, "Nisha", 24, 2, "nisha123@gamil.com", "1234567899");
		Librarian l2 = new Librarian(2, "Pooja", 21, 2, "pooja@gamil.com", "234567899");
		Librarian l3 = new Librarian(3, "Nikki", 19, 3, "nikki3@gamil.com", "987647899");
		Librarian l4 = new Librarian(4, "Sakshi", 25, 4, "sakshi@gamil.com", "8757667899");

		// int id, String title, String author, int publicationYear, boolean isAvailable
		Book b1 = new Book(1, "Life", "Nisha", 2022, true);
		Book b2 = new Book(2, "Love", "Maria", 2021, true);
		Book b3 = new Book(3, "Hate", "Jems", 2019, false);
		Book b4 = new Book(4, "Life of PI", "Nima", 2023, true);
		Book b5 = new Book(5, "Direction", "Sakshi", 2012, false);

		List<Book> bookList1 = new ArrayList<>();
		bookList1.add(b1);
		bookList1.add(b2);
		bookList1.add(b3);
		bookList1.add(b4);

		List<Book> bookList2 = new ArrayList<>();
		bookList2.add(b1);
		bookList2.add(b4);
		bookList2.add(b5);

		List<Book> bookList3 = new ArrayList<>();
		bookList3.add(b1);
		bookList3.add(b5);

		Map<Librarian, List<Book>> lbmap = new HashMap<>();
		lbmap.put(l1, bookList1);
		lbmap.put(l2, bookList2);
		lbmap.put(l3, bookList3);
		lbmap.put(l4, bookList2);

		return lbmap;
	}

	@Bean
	public List<Librarian> librarianList() {
		Librarian l1 = new Librarian(1, "Nisha", 24, 2, "nisha123@gamil.com", "1234567899");
		Librarian l2 = new Librarian(2, "Pooja", 21, 2, "pooja@gamil.com", "234567899");
		Librarian l3 = new Librarian(3, "Nikki", 19, 3, "nikki3@gamil.com", "987647899");
		Librarian l4 = new Librarian(4, "Sakshi", 25, 4, "sakshi@gamil.com", "8757667899");

		return Arrays.asList(l1, l2, l3, l4);
	}

	@Bean
	public List<Member> memberList() {
		Member m1 = new Member(1, "Nisha", 21, 4, "nisha123@gamil.com", "1234567899");
		Member m3 = new Member(3, "Pooja", 24, 3, "pooja@gamil.com", "234567899");
		Member m2 = new Member(2, "Nikki", 19, 2, "nikki3@gamil.com", "987647899");
		Member m4 = new Member(4, "Sakshi", 25, 1, "sakshi@gamil.com", "8757667899");
		Member m5 = new Member(5, "Nisha", 21, 6, "nisha123@gamil.com", "1234567899");

		return Arrays.asList(m1, m2, m3, m4, m5);

	}
	
}
