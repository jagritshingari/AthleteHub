package com.gym.AthleteHub.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gym.AthleteHub.dto.PageableResponse;
import com.gym.AthleteHub.model.Gym;

public interface GymService {

//	create 
	Gym createGym(Gym gym);
	
//	update
	Gym updateGym(String gymId,Gym gym);
	
//	delete
	void deleteGym(String gymId);
	
//	get all gym
	PageableResponse<Gym> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	Gym get(String gymId);
	
	
//	search gym by keyword
	List<Gym> getGymByKeyword(String keyword);
	
	
	
}
