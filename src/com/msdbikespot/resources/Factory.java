package com.msdbikespot.resources;

import com.msdbikespot.business.service.MSDBikeServiceImpl;
import com.msdbikespot.dao.MSDBikeDAOImpl;

public class Factory {
	
	public static MSDBikeServiceImpl createMSDBikeService()
	{
		return new MSDBikeServiceImpl();
	}

	public static MSDBikeDAOImpl createMSDBikeDAO()
	{
		return new MSDBikeDAOImpl();
	}
}
