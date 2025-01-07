package com.gym.AthleteHub.repository;

import com.gym.AthleteHub.model.Gym;
import com.gym.AthleteHub.model.GymUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymUserRepository extends JpaRepository<GymUsers,Long> {
}
