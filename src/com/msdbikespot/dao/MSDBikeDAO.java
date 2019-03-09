package com.msdbikespot.dao;

import java.util.Set;

import com.msdbikespot.bean.Bike;

public interface MSDBikeDAO {

	public String addBikes(Bike bike) throws Exception;
	public Set<Bike> getBikeDetails() throws Exception;
}
