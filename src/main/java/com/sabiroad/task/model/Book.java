package com.sabiroad.task.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer id;

	@Column(unique = true, name = "book_title")
	private String bookTitle;

	@Column(name = "book_description")
	private String bookDescription;

	@Column(name = "book_author")
	private String bookAuthor;

	@Column(name = "publication_date")
	private String publicationDate;

	public Book() {

	}

	public Book(String bookTitle, String bookDescription, String bookAuthor, String publicationDate) {

		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookAuthor = bookAuthor;
		this.publicationDate = publicationDate;
	}

	public Book(int id, String bookTitle, String bookDescription, String bookAuthor, String publicationDate) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookAuthor = bookAuthor;
		this.publicationDate = publicationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", bookDescription=" + bookDescription + ", bookAuthor="
				+ bookAuthor + ", publicationDate=" + publicationDate + "]";
	}

}
