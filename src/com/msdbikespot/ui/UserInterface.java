package com.msdbikespot.ui;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.msdbikespot.bean.Bike;
import com.msdbikespot.bean.BikeReport;
import com.msdbikespot.business.service.MSDBikeService;
import com.msdbikespot.resources.AppConfig;
import com.msdbikespot.resources.Factory;

public class UserInterface {
	
	public static void main(String[] args) {
		System.getProperty("java.class.path");
		try
		{		
			//Uncomment the method calls below, to get the corresponding output
			
			//addBikes();
			getBikeDetails();
		}
		catch (Exception e) {
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void addBikes() throws Exception{
		
		Bike bike = new Bike();
		
		bike.setBikeName("Augusta");
		bike.setPrice(956000.0);
		bike.setBikeId(1006);
		bike.setBikeSoldOn(LocalDate.now());
		bike.setCompanyName("General");
		bike.setSerialNumber("Gen:1256");
			
		LocalDate model=LocalDate.of(2014,11,2);
		bike.setModel(model);
		
		
		Bike bike1 = new Bike();
		
		bike1.setBikeName("Pulsar");
		bike1.setPrice(95000.0);
		bike1.setBikeId(1007);
		bike1.setBikeSoldOn(LocalDate.now());
		bike1.setCompanyName("Bajaj");
		bike1.setSerialNumber("Baj:1256");
			
		LocalDate model1=LocalDate.of(2013,10,1);
		
		bike1.setModel(model1);
		
		
		List<Bike> list = new ArrayList<Bike>();
		list.add(bike);
		list.add(bike1);
		
		MSDBikeService bikeService = Factory.createMSDBikeService();
		String ret = bikeService.addBikes(list);
		String message = null;
		if(ret.equals("success")){
			message="UserInterface.SUCCESS";
		}else{
		message="UserInterface.FAIL";	
		}
		System.out.println(AppConfig.PROPERTIES.getProperty(message));
	}
	
	// uncomment the neccessary code to check the output on your console
	
	//@SuppressWarnings("unused")
	public static void getBikeDetails() throws Exception{
		
		LocalDate model= LocalDate.of(2011, 2, 5);
		MSDBikeService bikeService = Factory.createMSDBikeService();
		Set<BikeReport> set = bikeService.getBikeDetails(model);
		
		System.out.println("BikeName\t\tPrice\t\t\tCompany\t\tSold on");
		System.out.println("********\t\t******\t\t\t******\t\t*******");
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		
		
		//Uncomment the code below to get respective output.
		
		for(BikeReport br :set){
			System.out.println(br.getBikeName() + "\t\t\t" + br.getPrice() + "\t\t" + br.getCompanyName() + "\t\t" + br.getBikeSoldOn().format(dtf));
		}
	}
}
