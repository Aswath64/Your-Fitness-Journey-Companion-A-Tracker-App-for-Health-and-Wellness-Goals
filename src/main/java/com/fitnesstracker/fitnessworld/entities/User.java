package com.fitnesstracker.fitnessworld.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fitnesstracker.fitnessworld.constant.Role;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;

    @JsonIgnore
    private Integer calorieGoal;

    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>(Set.of(Role.USER));

    @OneToMany
    private List<ActivityLog> activitieslog = new ArrayList<>();

    @OneToMany
    private List<ChallengeParticipation> challenges = new ArrayList<>();

    @OneToMany
    private List<FitnessGoal> goals = new ArrayList<>();
}
