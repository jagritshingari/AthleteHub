package com.gym.AthleteHub.response;

import com.gym.AthleteHub.dto.GymUserDTO;
import lombok.Data;

import java.util.List;

@Data
public class GymUserResponse {
    private List<GymUserDTO> users;

    public List<GymUserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<GymUserDTO> users) {
        this.users = users;
    }
}
