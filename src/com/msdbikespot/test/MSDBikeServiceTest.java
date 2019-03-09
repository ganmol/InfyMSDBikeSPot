package com.msdbikespot.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.msdbikespot.bean.Bike;
import com.msdbikespot.business.service.MSDBikeServiceImpl;

import com.msdbikespot.resources.Factory;


public class MSDBikeServiceTest {
	
	
@Rule
public ExpectedException ee=ExpectedException.none();
@Test	
public void addBikeValidDetails() throws Exception {
		// Write the code to test valid input  
	List<Bike>bikeList=new ArrayList<Bike>();
	Bike b=new Bike();
	b.setBikeName("Karizma");
	b.setPrice(95000.0);
	b.setBikeId(1227);
	LocalDate today=LocalDate.now();
	b.setBikeSoldOn(today);
	b.setCompanyName("Herro");
	LocalDate l=LocalDate.of(2015,05,12);
	b.setModel(l);
	b.setSerialNumber("Her:1256");
	bikeList.add(b);
	MSDBikeServiceImpl test=new MSDBikeServiceImpl();
	test.addBikes(bikeList);
	
	
	 }

	 
	@Test
	public void addBikeValidInValidBikeName() throws Exception {
		// Write the code to test valid input
		ee.expectMessage("Validator.INVALID_BIKENAME");
		List<Bike>bikeList=new ArrayList<Bike>();
		Bike b=new Bike();
		b.setBikeName("Yezzdi@123");
		b.setPrice(95000.0);
		b.setBikeId(1228);
		LocalDate today=LocalDate.now();
		b.setBikeSoldOn(today);
		b.setCompanyName("Java");
		LocalDate mod1=LocalDate.of(2015,5,12);
		b.setModel(mod1);
		b.setSerialNumber("Jav:1256");
		
		bikeList.add(b);
		Factory.createMSDBikeService().addBikes(bikeList);
	 }
	 
	

	@Test	
	public void getBikeDetailsInValidmodel() throws Exception{
		// Write the code to test valid input 
	//ee.expect(Exception.class);
		ee.expectMessage("MSDBikeService.NO_RECORDS_FOUND");
	Bike b=new Bike();
	LocalDate mod1=LocalDate.of(2018,3,5);
	b.setModel(mod1);
	MSDBikeServiceImpl msi=Factory.createMSDBikeService();
	msi.getBikeDetails(mod1);
	 }
}
