package com.load.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Load {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long loadId;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private int weight;
	private String comment;
	private String shipperId;
	private String date;

}
