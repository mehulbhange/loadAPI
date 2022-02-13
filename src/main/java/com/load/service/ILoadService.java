package com.load.service;

import java.util.List;

import com.load.entity.Load;

public interface ILoadService {
	
	public List<Load> getLoad(String shipperId);
	public Load getLoadById(long loadId);
	public String addLoad(Load load);
	public Load updateLoad(long loadId,Load updatedLoad);
	public void deleteLoad(long loadId);
	

}
