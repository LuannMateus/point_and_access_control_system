package com.luan.access_system.service;

import com.luan.access_system.model.WorkJourney;
import com.luan.access_system.repository.WorkJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

@Service
public class WorkJourneyService {

    final WorkJourneyRepository workJourneyRepository;

    @Autowired
    public WorkJourneyService(WorkJourneyRepository workJourneyRepository) {
        this.workJourneyRepository = workJourneyRepository;
    }

    public List<WorkJourney> findAll() {
        return this.workJourneyRepository.findAll();
    }

    public Optional<WorkJourney> findById(Long id) {
        return this.workJourneyRepository.findById(id);
    }

    public WorkJourney save(WorkJourney workJourney) {
        return this.workJourneyRepository.save(workJourney);
    }

    public WorkJourney update(WorkJourney workJourney) {

        Optional<WorkJourney> result = this.findById(workJourney.getId());

        if (result.isEmpty()) {
            return null;
        }

        return this.workJourneyRepository.save(workJourney);
    }

    public void deleteById(Long id) {
        this.workJourneyRepository.deleteById(id);
    }


}
