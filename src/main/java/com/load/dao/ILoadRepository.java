package com.load.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.load.entity.Load;

public interface ILoadRepository extends JpaRepository<Load, Long> {
	
	//@Query(value = "SELECT load FROM Load load WHERE load.shipperId = ?1")
	public List<Load> findByShipperId(String shipperId);
	
}
