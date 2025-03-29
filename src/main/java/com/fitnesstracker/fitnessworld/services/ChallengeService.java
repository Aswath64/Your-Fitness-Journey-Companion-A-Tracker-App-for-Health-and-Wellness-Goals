package com.fitnesstracker.fitnessworld.services;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fitnesstracker.fitnessworld.entities.Challenge;
import com.fitnesstracker.fitnessworld.entities.ChallengeParticipation;
import com.fitnesstracker.fitnessworld.entities.User;
import com.fitnesstracker.fitnessworld.repositories.ChallengeParticipationRepository;
import com.fitnesstracker.fitnessworld.repositories.ChallengeRepository;
import com.fitnesstracker.fitnessworld.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChallengeService {

  private final ChallengeRepository challengeRepository;
  private final UserRepository userRepository;
  private final ChallengeParticipationRepository participationRepository;

  @Transactional
  public void participateInChallenge(Long challengeId, Long userId) {
    Challenge challenge = challengeRepository.findById(challengeId)
        .orElseThrow(() -> new RuntimeException("Challenge not found!"));
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found!"));

    // Check if user is already participating
    boolean alreadyParticipating = participationRepository.existsByChallengeAndUser(challenge, user);
    if (alreadyParticipating) {
      throw new RuntimeException("User is already participating in this challenge!");
    }

    // Add user to challenge
    ChallengeParticipation participation = ChallengeParticipation.builder()
        .challenge(challenge)
        .user(user)
        .status("Joined")
        .build();

    participationRepository.save(participation);
  }

  @Transactional
  public Challenge createChallenge(Challenge challenge) {
    return challengeRepository.save(challenge);
  }

  @Transactional(readOnly = true)
  public Page<Challenge> getChallengesByStartDateAfter(LocalDate startDate, Pageable pageable) {
    return challengeRepository.findChallengesByStartDateAfter(startDate, pageable);
  }
}
