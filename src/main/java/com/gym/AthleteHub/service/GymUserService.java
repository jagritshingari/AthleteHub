package com.gym.AthleteHub.service;

import com.gym.AthleteHub.dto.GymUserDTO;
import com.gym.AthleteHub.model.GymUsers;
import com.gym.AthleteHub.response.GymUserResponse;

public interface GymUserService {
    GymUserResponse getAllUsers();

    GymUserDTO createUser(GymUsers user);
}
