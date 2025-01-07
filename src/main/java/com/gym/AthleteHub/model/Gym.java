package com.gym.AthleteHub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="tbl_gym")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String gymId;

    private String gymName;
    private String address;
    private Long contactNumber;

    @OneToMany(mappedBy = "gym")
    private List<GymUsers> gymUser;


}
