package com.msdbikespot.bean;

import java.time.LocalDate;


public class Bike {
	
	private Integer bikeId;
	private String serialNumber;
	private String bikeName;
	private Double price;
	private String companyName;
	private LocalDate model;
	private LocalDate bikeSoldOn;
	
	public Integer getBikeId() {
		return bikeId;
	}
	public void setBikeId(Integer bikeId) {
		this.bikeId = bikeId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
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
	public LocalDate getModel() {
		return model;
	}
	public void setModel(LocalDate model) {
		this.model = model;
	}
	public LocalDate getBikeSoldOn() {
		return bikeSoldOn;
	}
	public void setBikeSoldOn(LocalDate bikeSoldOn) {
		this.bikeSoldOn = bikeSoldOn;
	}
	
	
}
