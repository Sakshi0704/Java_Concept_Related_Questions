package com.masai;

import java.util.Objects;

public class Book {
	   private int id;
	   private  String title;
	   private  String author;
	   private int publicationYear;
	   private boolean isAvailable;
	   
	   
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int id, String title, String author, int publicationYear, boolean isAvailable) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isAvailable = isAvailable;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
				+ ", isAvailable=" + isAvailable + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, isAvailable, publicationYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && isAvailable == other.isAvailable
				&& publicationYear == other.publicationYear && Objects.equals(title, other.title);
	}

	   
	   
}
