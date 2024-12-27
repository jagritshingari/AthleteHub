package com.gym.AthleteHub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.AthleteHub.model.Gym;

public interface GymRepository extends JpaRepository<Gym, String> {

	List<Gym> findByGymNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String keyword);
}
