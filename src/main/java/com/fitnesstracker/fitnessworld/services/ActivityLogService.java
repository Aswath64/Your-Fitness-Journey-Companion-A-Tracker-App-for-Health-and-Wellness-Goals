package com.fitnesstracker.fitnessworld.services;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import com.fitnesstracker.fitnessworld.repositories.ActivityLogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Transactional
    public ActivityLog logActivity(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    public Page<ActivityLog> getUserActivityLogs(Long userId, Pageable pageable) {
        return activityLogRepository.findByUserId(userId, pageable);
    }

    public Page<ActivityLog> getActivityLogsByDateRange(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return activityLogRepository.findByDateRange(startDate, endDate, pageable);
    }
}
