package com.load.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.load.entity.Load;
import com.load.service.LoadServiceImpl;

@RestController
public class LoadController {
	
	@Autowired
	LoadServiceImpl loadService;
	
	
	//This function used to add the load details
	@PostMapping("/load")
	ResponseEntity<String> addLoad(@RequestBody Load load) {
		return new ResponseEntity<String>(loadService.addLoad(load),HttpStatus.ACCEPTED);
	}
	
	//It will return the Load if exists with the given loadId
	@GetMapping("/load/{loadId}")
	ResponseEntity<Load> getLoadById(@PathVariable("loadId") long loadId) {
		return new ResponseEntity<Load>(loadService.getLoadById(loadId),HttpStatus.OK);
	}
	
	//This function will return loads with the given shipingId
	@GetMapping("/load")
	ResponseEntity<List<Load>> getLoadByShipperId(@RequestParam String shipperId){
		return new ResponseEntity<List<Load>>(loadService.getLoad(shipperId), HttpStatus.OK);
	}
	
	
	//It will update the the load details if the given load details exists with the given loadId
	@PutMapping("/load/{loadId}")
	ResponseEntity<String> updateLoad(@PathVariable("loadId") long loadId, @RequestBody Load load) {
		Load updatedLoad = loadService.updateLoad(loadId, load);
		String msg = "loads details updated successfully";
		if(updatedLoad != null)
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>("Something went wrong", HttpStatus.NOT_ACCEPTABLE);
	}
	
	//It is used to delete the load details with given loadId
	@DeleteMapping("/load/{loadId}")
	void deleteLoad(@PathVariable("loadId") long loadId) {
		loadService.deleteLoad(loadId);
	}
	
	
}
