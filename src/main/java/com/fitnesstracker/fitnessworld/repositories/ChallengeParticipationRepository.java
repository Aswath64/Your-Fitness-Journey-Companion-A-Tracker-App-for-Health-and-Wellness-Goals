package com.fitnesstracker.fitnessworld.repositories;

import com.fitnesstracker.fitnessworld.entities.Challenge;
import com.fitnesstracker.fitnessworld.entities.ChallengeParticipation;
import com.fitnesstracker.fitnessworld.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChallengeParticipationRepository extends JpaRepository<ChallengeParticipation, Long> {

    @Query("SELECT COUNT(cp) > 0 FROM ChallengeParticipation cp WHERE cp.challenge = :challenge AND cp.user = :user")
    boolean existsByChallengeAndUser(@Param("challenge") Challenge challenge, @Param("user") User user);
}
