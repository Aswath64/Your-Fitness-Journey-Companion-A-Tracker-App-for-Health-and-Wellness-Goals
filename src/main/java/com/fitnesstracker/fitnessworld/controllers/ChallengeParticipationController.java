package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.ChallengeParticipation;
import com.fitnesstracker.fitnessworld.services.ChallengeParticipationService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participations")
@RequiredArgsConstructor
public class ChallengeParticipationController {

    private final ChallengeParticipationService participationService;

    @PostMapping("/{challengeId}")
    public ResponseEntity<String> participateInChallenge(
            @PathVariable Long challengeId,
            @RequestParam Long userId) {

        participationService.participateInChallenge(challengeId, userId);
        return ResponseEntity.ok("User successfully joined the challenge!");
    }


    @GetMapping
    public ResponseEntity<Page<ChallengeParticipation>> getAllParticipations(Pageable pageable) {
        return ResponseEntity.ok(participationService.getAllParticipations(pageable));
    }


    @DeleteMapping("/{participationId}")
    public ResponseEntity<String> removeParticipation(@PathVariable Long participationId) {
        participationService.removeParticipation(participationId);
        return ResponseEntity.ok("Participation successfully removed.");
    }
}
