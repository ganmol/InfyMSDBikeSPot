package com.msdbikespot.business.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.msdbikespot.bean.Bike;
import com.msdbikespot.bean.BikeReport;

public interface MSDBikeService {

	public String addBikes(List<Bike> bikeList) throws Exception;
	public Set<BikeReport> getBikeDetails(LocalDate model) throws Exception;
}
