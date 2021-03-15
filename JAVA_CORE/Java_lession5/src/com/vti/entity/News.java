package com.vti.entity;

public class News  implements  iNews { 

	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	
	// getter
	public String getAuthor() {
		return author;
	}
	public float getAverageRate() {
		return averageRate;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public String getTitle() {
		return title;
	}
	
	//setter
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void Display() {
		System.out.println("Title: " + title);
		System.out.println("PublishDate" + publishDate);
		System.out.println("Content" + content);
		System.out.println("Author" + author);
		
	}
	@Override
	public void Calculate() {
		// TODO Auto-generated method stub
		
	}
}
