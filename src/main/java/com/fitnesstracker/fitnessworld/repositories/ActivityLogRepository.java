package com.fitnesstracker.fitnessworld.repositories;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    @Query("SELECT a FROM ActivityLog a WHERE a.user.id = :userId ORDER BY a.logDate DESC")
    Page<ActivityLog> findByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT a FROM ActivityLog a WHERE a.logDate BETWEEN :startDate AND :endDate")
    Page<ActivityLog> findByDateRange(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);
}
