package com.gym.AthleteHub.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.AthleteHub.exceptions.APIException;
import com.gym.AthleteHub.model.Profiles;
import com.gym.AthleteHub.repositories.ProfileRepository;
import com.gym.AthleteHub.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Override
	public Profiles createProfiles(Profiles profile) {
		
		try {
			Profiles saved = profileRepo.save(profile);
			return saved;
			
		}catch(Exception ex) {
			throw new APIException(ex.getMessage());
		}
	}
	
	public Profiles updateProfiles(Long profileId,Profiles profile) {
		
		Profiles existingProfile = profileRepo.findById(profileId).orElseThrow(()->new APIException("Profile Not Found wiht the given id : "+profileId));
		
		existingProfile.setFullName(profile.getFullName());
		existingProfile.setAge(profile.getAge());
		existingProfile.setGender(profile.getGender());
		existingProfile.setGoal(profile.getGoal());
		existingProfile.setHeight(profile.getHeight());
		existingProfile.setWeight(profile.getWeight());
		Profiles updatedProfile = profileRepo.save(existingProfile);
		
		return updatedProfile;
	}
	
	
	public Profiles getProfileById(Long profileId) {
		Profiles profile = profileRepo.findById(profileId).orElseThrow(()->new APIException("Profile Not Found wiht the given id : "+profileId));
        return profile;
    }
	
	public void deleteProfileById(Long profileId) {

		Profiles profile = profileRepo.findById(profileId).orElseThrow(()->new APIException("Profile Not Found wiht the given id : "+profileId));
        profileRepo.delete(profile);
    }

	

	
}
