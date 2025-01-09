package com.gym.AthleteHub.services;

import org.springframework.context.annotation.Profile;

import com.gym.AthleteHub.model.Profiles;


public interface ProfileService {
	
//	create
	Profiles createProfiles(Profiles profile);
//	update
	Profiles updateProfiles(Long profileId,Profiles profile);
	
//	get profile by id
	Profiles getProfileById(Long profileId);
	
//	delete profile by id
	void deleteProfileById(Long profileId);
}
