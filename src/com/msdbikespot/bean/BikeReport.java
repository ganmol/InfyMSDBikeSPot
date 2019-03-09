package com.msdbikespot.bean;

import java.time.LocalDate;



public class BikeReport {
	//Implement the class as per class diagram 
	private String bikeName;
	private Double price;
	private String companyName;
	private LocalDate bikeSoldOn;
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public LocalDate getBikeSoldOn() {
		return bikeSoldOn;
	}
	public void setBikeSoldOn(LocalDate bikeSoldOn) {
		this.bikeSoldOn = bikeSoldOn;
	}
	
}
