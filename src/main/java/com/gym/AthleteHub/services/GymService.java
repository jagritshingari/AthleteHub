package com.gym.AthleteHub.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gym.AthleteHub.dto.PageableResponse;
import com.gym.AthleteHub.model.Gym;

public interface GymService {

//	create 
	ResponseEntity<Object> createGym(Gym gym);
	
//	update
	ResponseEntity<Object> updateGym(String gymId,Gym gym);
	
//	delete
	ResponseEntity<Object> deleteGym(String gymId);
	
//	get all gym
	PageableResponse<Gym> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	ResponseEntity<Object> get(String gymId);
	
	
//	search gym by keyword
	List<Gym> getGymByKeyword(String keyword);
	
	
	
}
