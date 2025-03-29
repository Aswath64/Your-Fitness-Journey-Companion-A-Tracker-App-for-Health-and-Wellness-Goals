package com.fitnesstracker.fitnessworld.repositories;

import com.fitnesstracker.fitnessworld.entities.Challenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    Page<Challenge> findChallengesByStartDateAfter(@Param("startDate") LocalDate startDate, Pageable pageable);
}
