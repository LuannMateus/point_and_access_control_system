package com.luan.access_system.repository;

import com.luan.access_system.model.WorkJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> {
}
