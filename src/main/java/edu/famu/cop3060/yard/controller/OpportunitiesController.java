package edu.famu.cop3060.yard.controller;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import edu.famu.cop3060.yard.service.OpportunitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunitiesController {

    private static final Logger logger =
            LoggerFactory.getLogger(OpportunitiesController.class);

    private final OpportunitiesService service;

    public OpportunitiesController(OpportunitiesService service) {
        this.service = service;
    }

    // GET all + filter
    @GetMapping
    public ResponseEntity<List<OpportunityDTO>> getAll(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String q) {

        return ResponseEntity.ok(service.getOpportunities(type, q));
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<OpportunityDTO> getById(@PathVariable String id) {

        return service.getOpportunityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<OpportunityDTO> create(@RequestBody OpportunityDTO dto) {

        logger.info("POST /api/opportunities — title={}", dto.getTitle());

        OpportunityDTO created = service.create(dto);

        return ResponseEntity.status(201).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OpportunityDTO> update(
            @PathVariable String id,
            @RequestBody OpportunityDTO dto) {

        logger.info("PUT /api/opportunities/{} — update request", id);

        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("PUT attempted on nonexistent id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        boolean deleted = service.delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}