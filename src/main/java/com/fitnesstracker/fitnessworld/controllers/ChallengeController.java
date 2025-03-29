package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.Challenge;
import com.fitnesstracker.fitnessworld.services.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge) {
        Challenge createdChallenge = challengeService.createChallenge(challenge);
        return ResponseEntity.ok(createdChallenge);
    }

    @PostMapping("/{challengeId}/participate")
    public ResponseEntity<String> participateInChallenge(@PathVariable Long challengeId, @RequestParam Long userId) {
        challengeService.participateInChallenge(challengeId, userId);
        return ResponseEntity.ok("Successfully joined the challenge!");
    }

    @GetMapping("/upcoming")
    public ResponseEntity<Page<Challenge>> getUpcomingChallenges(
            @RequestParam LocalDate startDate, Pageable pageable) {
        return ResponseEntity.ok(challengeService.getChallengesByStartDateAfter(startDate, pageable));
    }
}
