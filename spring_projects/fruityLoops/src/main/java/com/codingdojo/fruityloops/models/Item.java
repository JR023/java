package com.codingdojo.fruityloops.models;

public class Item {
	//member variables
	public String name;
	public double price;
	
	//constructor
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	//getters
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	//setters
	public void setPrice(double price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
}
