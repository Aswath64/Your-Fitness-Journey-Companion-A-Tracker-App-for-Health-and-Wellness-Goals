package com.fitnesstracker.fitnessworld.services;

import com.fitnesstracker.fitnessworld.entities.Challenge;
import com.fitnesstracker.fitnessworld.entities.ChallengeParticipation;
import com.fitnesstracker.fitnessworld.entities.User;
import com.fitnesstracker.fitnessworld.repositories.ChallengeParticipationRepository;
import com.fitnesstracker.fitnessworld.repositories.ChallengeRepository;
import com.fitnesstracker.fitnessworld.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChallengeParticipationService {

    private final ChallengeParticipationRepository participationRepository;
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;

    @Transactional
    public ChallengeParticipation participateInChallenge(Long challengeId, Long userId) {
        Optional<Challenge> challengeOpt = challengeRepository.findById(challengeId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (challengeOpt.isEmpty() || userOpt.isEmpty()) {
            throw new RuntimeException("Challenge or User not found!");
        }

        Challenge challenge = challengeOpt.get();
        User user = userOpt.get();

        // Check if the user is already participating
        if (participationRepository.existsByChallengeAndUser(challenge, user)) {
            throw new RuntimeException("User is already participating in this challenge!");
        }

        // Create new participation record
        ChallengeParticipation participation = ChallengeParticipation.builder()
                .user(user)
                .challenge(challenge)
                .status("Joined") // Default status
                .build();

        return participationRepository.save(participation);
    }

    @Transactional(readOnly = true)
    public Page<ChallengeParticipation> getAllParticipations(Pageable pageable) {
        return participationRepository.findAll(pageable);
    }

    @Transactional
    public void removeParticipation(Long participationId) {
        if (!participationRepository.existsById(participationId)) {
            throw new RuntimeException("Participation not found!");
        }
        participationRepository.deleteById(participationId);
    }
}
