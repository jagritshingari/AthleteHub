package com.gym.AthleteHub.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gym.AthleteHub.dto.PageableResponse;
import com.gym.AthleteHub.hubutil.HubUtil;
import com.gym.AthleteHub.model.Gym;
import com.gym.AthleteHub.repositories.GymRepository;
import com.gym.AthleteHub.services.GymService;

public class GymServiceImpl implements GymService  {
	
	@Autowired
	private GymRepository gymRepository;
	
	

	@Override
	public ResponseEntity<Object> createGym(Gym gym) {
		// TODO Auto-generated method stub
		try {
			Gym saved = gymRepository.save(gym);
			return new ResponseEntity<>(saved,HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public ResponseEntity<Object> updateGym(String gymId, Gym gym) {
		// TODO Auto-generated method stub
		try {
			
			Gym existingGym = gymRepository.findById(gymId).orElse(null);
			if(existingGym == null) {
				return new ResponseEntity<>("Gym Not Found with given id",HttpStatus.BAD_REQUEST);
			}
			
			existingGym.setGymName(gym.getGymName());
			existingGym.setAddress(gym.getAddress());
			existingGym.setContactNumber(gym.getContactNumber());
			
			Gym updated = gymRepository.save(existingGym);
			return new ResponseEntity<>(updated,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> deleteGym(String gymId) {
		// TODO Auto-generated method stub
		try {
			
			Gym gym = gymRepository.findById(gymId).orElse(null);
			if(gym == null) {
				return new ResponseEntity<>("Gym Not Found with given id",HttpStatus.BAD_REQUEST);
			}
			gymRepository.delete(gym);
			return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public PageableResponse<Gym> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		
		
		Sort sort = (sortDir.contentEquals("Desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy));
		Pageable pageable = PageRequest.of(pageNumber, pageSize,sort);
		Page<Gym> gymList = gymRepository.findAll(pageable);
		PageableResponse<Gym> response =  HubUtil.getPageableResponse(gymList);
		return response;
		
	}

	@Override
	public ResponseEntity<Object> get(String gymId) {
		// TODO Auto-generated method stub
		
		try {
			Gym gym = gymRepository.findById(gymId).orElse(null);
			if(gym == null) {
				return new ResponseEntity<>("Gym Not Found with given id",HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(gym,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Gym> getGymByKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<Gym> gymList = gymRepository.findByGymNameContainingIgnoreCaseOrAddressContainingIgnoreCase(keyword);
		return gymList;
	}

}
