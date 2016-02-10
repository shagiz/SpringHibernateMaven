package com.site.code.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ListData {
	
	@Id
	@GeneratedValue
	private long id;
	private int key;
	private String name;
	private double price;
	private Date date;
	@ManyToOne(cascade={CascadeType.PERSIST})


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
