package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.chef;

@Repository 
public interface chefRepository extends JpaRepository<chef, String>{
	

		
		//delete chef by last name
		@Transactional
		public void deleteChefByLastName(String lastName);

}
