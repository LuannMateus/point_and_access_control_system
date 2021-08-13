package com.luan.access_system.controller;

import com.luan.access_system.model.WorkJourney;
import com.luan.access_system.service.WorkJourneyService;
import javassist.NotFoundException;
import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.hibernate.engine.spi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/journey")
public class WorkJourneyController {

    final WorkJourneyService workJourneyService;

    @Autowired
    private WorkJourneyController(WorkJourneyService workJourneyService) {
        this.workJourneyService = workJourneyService;
    }

    @GetMapping
    public ResponseEntity<List<WorkJourney>> findAll() {
        return ResponseEntity.ok(workJourneyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkJourney> findById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(workJourneyService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found!")));
    }

    @PostMapping
    public ResponseEntity<WorkJourney> save(@RequestBody WorkJourney workJourney) {
        WorkJourney result = this.workJourneyService.save(workJourney);

        return ResponseEntity.status(201).body(result);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody WorkJourney workJourney) {
        WorkJourney result = this.workJourneyService.update(workJourney);

        if (result == null) {
            return  ResponseEntity.status(404).body("Not Found!");
        }

        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.workJourneyService.deleteById(id);
    }


}
