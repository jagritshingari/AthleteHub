package com.gym.AthleteHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.AthleteHub.model.Profiles;


@Repository
public interface ProfileRepository extends JpaRepository<Profiles,Long> {

}
