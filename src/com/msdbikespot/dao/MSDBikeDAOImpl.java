package com.msdbikespot.dao;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.msdbikespot.bean.Bike;

/**
 * DAO class to perform database operations
 * 
 * @author ETA
 */
public class MSDBikeDAOImpl implements MSDBikeDAO {

	public String addBikes(Bike bike) throws Exception {
		return "success";
	}

	public Set<Bike> getBikeDetails() throws Exception {

		Set<Bike> set = new LinkedHashSet<Bike>();

		try {

			Bike bike = new Bike();

			bike.setBikeId(1001);
			bike.setBikeName("CBR");

			LocalDate date=LocalDate.of(2013, 3, 12);
				
			bike.setBikeSoldOn(date);
			bike.setCompanyName("Honda");
			bike.setPrice(600000.0);

			LocalDate date5 =LocalDate.of(2013, 1,12 );
			bike.setModel(date5);
			
			bike.setSerialNumber("Hon:1231");

			
			Bike bike1 = new Bike();

			bike1.setBikeId(1002);
			bike1.setBikeName("CBZ");
			
			LocalDate date2 =LocalDate.of(2014, 3, 12);
			bike1.setBikeSoldOn(date2);
			bike1.setCompanyName("Herro");
			bike1.setPrice(90000.0);

			LocalDate date6 =LocalDate.of(2014, 2, 12);
			bike1.setModel(date6);
			bike1.setSerialNumber("Her:1231");
			

			Bike bike2 = new Bike();

			bike2.setBikeId(1003);
			bike2.setBikeName("Bullet");
			
			LocalDate date3 = LocalDate.of(2012, 3,12);
			bike2.setBikeSoldOn(date3);
			bike2.setCompanyName("Enfield");
			bike2.setPrice(100000.0);

			LocalDate date7 = LocalDate.of(2012, 2, 12);
			bike2.setModel(date7);
			bike2.setSerialNumber("Enf:1231");

			
			Bike bike3 = new Bike();

			bike3.setBikeId(1004);
			bike3.setBikeName("Karizma");
			
			LocalDate date4 = LocalDate.of(2011, 3, 12);
			bike3.setBikeSoldOn(date4);
			bike3.setCompanyName("Herro");
			bike3.setPrice(150000.0);

			LocalDate date8 = LocalDate.of(2011, 2, 12);
			bike3.setModel(date8);
			bike3.setSerialNumber("Her:1231");

			set.add(bike);
			set.add(bike1);
			set.add(bike2);
			set.add(bike3);

		} catch (Exception exception) {
			DOMConfigurator
					.configure("src/com/msdbikespot/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw new Exception("MSDBikeDAO.TECHNICAL_ERROR");
		}
		return set;
	}
}