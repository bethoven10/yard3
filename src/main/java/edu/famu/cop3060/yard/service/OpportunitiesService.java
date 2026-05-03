package edu.famu.cop3060.yard.service;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import edu.famu.cop3060.yard.entity.Opportunity;
import edu.famu.cop3060.yard.repository.OpportunityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunitiesService {

    private static final Logger logger =
            LoggerFactory.getLogger(OpportunitiesService.class);

    private final OpportunityRepository repository;

    public OpportunitiesService(OpportunityRepository repository) {
        this.repository = repository;
    }

    // --------------------
    // GET ALL + FILTER
    // --------------------
    public List<OpportunityDTO> getOpportunities(String type, String q) {

        List<Opportunity> list = repository.findAll();

        return list.stream()
                .filter(o -> type == null || o.getType().equalsIgnoreCase(type))
                .filter(o -> q == null ||
                        o.getTitle().toLowerCase().contains(q.toLowerCase()))
                .map(this::toDTO)
                .toList();
    }

    // --------------------
    // GET BY ID
    // --------------------
    public Optional<OpportunityDTO> getOpportunityById(String id) {
        return repository.findById(id).map(this::toDTO);
    }

    // --------------------
    // CREATE (FIXED)
    // --------------------
    public OpportunityDTO create(OpportunityDTO dto) {

        Opportunity entity = new Opportunity();

        // ❌ DO NOT SET ID FROM DTO
        // entity.setId(dto.getId());

        entity.setTitle(dto.getTitle());
        entity.setType(dto.getType());
        entity.setSponsor(dto.getSponsor());
        entity.setDeadline(dto.getDeadline());
        entity.setDescription(dto.getDescription());
        entity.setTags(dto.getTags());
        entity.setUrl(dto.getUrl());

        Opportunity saved = repository.save(entity);

        logger.info("Opportunity created with id={}", saved.getId());

        return toDTO(saved);
    }

    // --------------------
    // UPDATE
    // --------------------
    public Optional<OpportunityDTO> update(String id, OpportunityDTO dto) {

        if (!repository.existsById(id)) {
            logger.warn("Update attempted for nonexistent id={}", id);
            return Optional.empty();
        }

        Opportunity entity = new Opportunity();

        entity.setId(id); // keep ID for update

        entity.setTitle(dto.getTitle());
        entity.setType(dto.getType());
        entity.setSponsor(dto.getSponsor());
        entity.setDeadline(dto.getDeadline());
        entity.setDescription(dto.getDescription());
        entity.setTags(dto.getTags());
        entity.setUrl(dto.getUrl());

        Opportunity saved = repository.save(entity);

        return Optional.of(toDTO(saved));
    }

    // --------------------
    // DELETE
    // --------------------
    public boolean delete(String id) {

        if (!repository.existsById(id)) {
            logger.warn("Delete attempted for nonexistent id={}", id);
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    // --------------------
    // DTO MAPPING
    // --------------------
    private OpportunityDTO toDTO(Opportunity o) {
        return new OpportunityDTO(
                o.getId(),
                o.getTitle(),
                o.getType(),
                o.getSponsor(),
                o.getDeadline(),
                o.getDescription(),
                o.getTags(),
                o.getUrl()
        );
    }
}