package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.rms.model.RestaurantManager;

@Repository
public interface restaurantManagerRepository extends JpaRepository<RestaurantManager, String> {
	
	
 
}
