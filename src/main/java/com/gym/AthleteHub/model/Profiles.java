package com.gym.AthleteHub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="tbl_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;

    private String fullName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private enum Gender{
        Male,
        Female
    }
    private double height;
    private double weight;
    private String goal;

    @OneToOne
    @JoinColumn(name = "user_id")
    private GymUsers gymUsers;

}
