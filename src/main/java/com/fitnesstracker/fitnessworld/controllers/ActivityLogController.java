package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import com.fitnesstracker.fitnessworld.services.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @PostMapping
    public ResponseEntity<ActivityLog> logActivity(@RequestBody ActivityLog activityLog) {
        ActivityLog savedActivity = activityLogService.logActivity(activityLog);
        return ResponseEntity.ok(savedActivity);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<ActivityLog>> getUserActivityLogs(
            @PathVariable Long userId, Pageable pageable) {
        return ResponseEntity.ok(activityLogService.getUserActivityLogs(userId, pageable));
    }

    @GetMapping("/date-range")
    public ResponseEntity<Page<ActivityLog>> getActivityLogsByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            Pageable pageable) {
        return ResponseEntity.ok(activityLogService.getActivityLogsByDateRange(startDate, endDate, pageable));
    }
}
     