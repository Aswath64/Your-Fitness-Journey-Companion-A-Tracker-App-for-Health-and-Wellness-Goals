package com.fitnesstracker.fitnessworld.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Table(name = "fitness_goals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalType;
    private Integer targetValue;
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
