package com.gym.AthleteHub.dto;

import com.gym.AthleteHub.model.GymUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymUserDTO {

    private Long userId;
    private String username;
    private String email;
    private String role;
    private Date createdAt;
    private String gymId;


    private ProfilesDTO profiles;
}
