package com.msdbikespot.business.validator;

import org.apache.log4j.Logger;

import java.time.LocalDate;

import org.apache.log4j.xml.DOMConfigurator;

import com.msdbikespot.bean.Bike;
import com.msdbikespot.resources.AppConfig;

public class Validator {

	public void validate(Bike bike) throws Exception {
		// Use isValidBikeName, isValidModel, isValidCompanyName, isValidBikeSoldOn, isValidPrice, isValidSerialNumber to validate the bike details
				// For invalid inputs throw exceptions with the corresponding messages
		try{
		if(!isValidBikeName(bike.getBikeName()))
			throw new Exception("Validator.INVALID_BIKENAME");
		else if(!isValidModel(bike.getModel()))
			throw new Exception("Validator.INVALID_MODEL");
		else if(!isValidCompanyName(bike.getCompanyName()))
			throw new Exception("Validator.INVALID_COMPANY_NAME");
		else if(!isValidBikeSoldOn(bike.getBikeSoldOn()))
			throw new Exception("Validator.INVALID_BIKE_SOLD_ON");
		else if(!isValidSerialNumber(bike.getSerialNumber(),bike.getCompanyName()))
			throw new Exception("Validator.INVALID_SERIAL_NUMBER");
		else if(!isValidPrice(bike.getPrice()))
			throw new Exception("Validator.INVALID_PRICE");
	}
		catch(Exception e) {
		DOMConfigurator.configure("src/com/msdbikespot/resources/log4j.xml");
		Logger logger = Logger.getLogger(AppConfig.class);
		logger.error(e.getMessage(), e);
		throw e;
	}
	}
	public Boolean isValidBikeName(String bikeName) {
		if(bikeName.trim().matches("[A-Za-z0-9 ]+"))
			return true;
		else
			return false;
	}

	public Boolean isValidModel(LocalDate model) {
		LocalDate today=LocalDate.now();
		LocalDate before5=today.minusYears(5);
		if(!(model.isAfter(today))&& !(model.isBefore(before5)))
			return true;
		else
			return false;
	}

	public Boolean isValidCompanyName(String companyName) {
		if(companyName.matches("[A-Z].*"))
			return true;
		else
			return false;
	}

	public Boolean isValidBikeSoldOn(LocalDate bikeSoldOn) {
		LocalDate today=LocalDate.now();
		if(bikeSoldOn.equals(today))
			return true;
		else
			return false;
	}

	public Boolean isValidPrice(Double price) {
		if(price>=50000)
			return true;
		else
			return false;
	}

	public Boolean isValidSerialNumber(String serialNumber, String companyName) {
		String s=companyName.substring(0,3);
		String a=s+":[\\d]+";
		if(serialNumber.matches(a))
			return true;
		else
			return false;
		
		

	}
}
