package com.plazmateq.LibraryManageService.model;

public class Book {

	private int id;
	private String name;
	private String author;
	private String about;
	private int copy;

	public Book() {}
	
	public Book(int id, String name, String author, String about, int copy) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.about = about;
		this.copy=copy;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getCopy() {
		return copy;
	}

	public void setCopy(int copy) {
		this.copy = copy;
	}
}
