package com.load.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.load.dao.ILoadRepository;
import com.load.entity.Load;

@Service
public class LoadServiceImpl implements ILoadService {
	
	@Autowired
	ILoadRepository loadRepository;

	@Override
	public List<Load> getLoad(String ShipperId) {
		return loadRepository.findByShipperId(ShipperId);
	}

	@Override
	public Load getLoadById(long loadId) {
		return loadRepository.findById(loadId).get();
	}

	@Override
	public String addLoad(Load load) {
		Load addedLoad = loadRepository.save(load);
		if(addedLoad != null)
			System.out.println("Not null "+addedLoad);
		String msg = "loads details added successfully";
		return msg;
	}

	@Override
	public Load updateLoad(long loadId,Load updatedLoad) {
		Optional<Load> load = loadRepository.findById(loadId);
		if(load.isPresent()) {
			updatedLoad.setLoadId(load.get().getLoadId());
			return loadRepository.save(updatedLoad);
				
		}else
			return null;
	}

	@Override
	public void deleteLoad(long loadId) {
		loadRepository.deleteById(loadId);
	}

}
