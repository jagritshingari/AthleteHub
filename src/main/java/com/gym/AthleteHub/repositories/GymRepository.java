package com.gym.AthleteHub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.AthleteHub.model.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, String> {

	List<Gym> findByGymNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name,String address);
}
