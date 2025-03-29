package com.fitnesstracker.fitnessworld.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String challengeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reward;

    @OneToMany(mappedBy = "challenge")
    private List<ChallengeParticipation> participants;
}
