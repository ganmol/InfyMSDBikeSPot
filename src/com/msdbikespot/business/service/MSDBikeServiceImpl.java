package com.msdbikespot.business.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.msdbikespot.bean.Bike;
import com.msdbikespot.bean.BikeReport;
import com.msdbikespot.business.validator.Validator;
import com.msdbikespot.dao.MSDBikeDAOImpl;
import com.msdbikespot.resources.AppConfig;
import com.msdbikespot.resources.Factory;
//import com.msdbikespot.resources.Logger;

public class MSDBikeServiceImpl implements MSDBikeService {

	public String addBikes(List<Bike> bikeList) throws Exception{
		try{
			Validator v=new Validator();
			
			MSDBikeDAOImpl mi=Factory.createMSDBikeDAO();
			String x=" ";
			for(Bike b:bikeList){
				v.validate(b);
				x=mi.addBikes(b);
			
			}
			
			return x;
		}
		catch (Exception e) {
			if(e.getMessage().contains("Service")){
			DOMConfigurator.configure("src/com/msdbikespot/resources/log4j.xml");
			Logger logger = Logger.getLogger(AppConfig.class);
			logger.error(e.getMessage(), e);
		}throw e;
			}
		}
		
	
	
	public Set<BikeReport> getBikeDetails(LocalDate model) throws Exception{
		try{
			MSDBikeDAOImpl mi=Factory.createMSDBikeDAO();
			Set<Bike> s=mi.getBikeDetails();
			Set<BikeReport> br=new HashSet<BikeReport>();
			for(Bike b:s){
				if(b.getModel().equals(model)|b.getModel().isAfter(model)){
					BikeReport bk=new BikeReport();
					bk.setBikeName(b.getBikeName());
					bk.setBikeSoldOn(b.getBikeSoldOn());
					bk.setCompanyName(b.getCompanyName());
					bk.setPrice(b.getPrice());
					br.add(bk);
				}
			}
			if(br.isEmpty()){
				throw new Exception("MSDBikeService.NO_RECORDS_FOUND");
			}
			return br;
		
		
		}
	catch (Exception e) {
		if(e.getMessage().contains("Service")){
		DOMConfigurator.configure("src/com/msdbikespot/resources/log4j.xml");
		Logger logger = Logger.getLogger(AppConfig.class);
		logger.error(e.getMessage(), e);
	}throw e;
		}
	}
}
