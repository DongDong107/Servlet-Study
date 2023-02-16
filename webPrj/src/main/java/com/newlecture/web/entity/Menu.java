package com.newlecture.web.entity;

import java.sql.DriverManager;
import java.util.Date;

public class Menu {
	private int id;
	private String name;
	private int price;
	private String img;
	private Date regDate;
	private String images;
	
	static {
		
	}
	
	public Menu() {
		Menu menu = new Menu();
//		DriverManager.registerDriver(this);
	}	
	
	public Menu(int id, String name, int price, String img, Date regDate, String images) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.regDate = regDate;
		this.images = images;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", regDate=" + regDate
				+ ", images=" + images + "]";
	}

	
	
	
	
	// 생성자(기본, 오버로드) 
	// 켓더세터    
	// toString(); -> 개체값을 문자로 뽑아내는
	// 아묻따 저 세 개 만들기
	
}