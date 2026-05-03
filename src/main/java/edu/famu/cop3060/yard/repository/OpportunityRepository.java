package edu.famu.cop3060.yard.repository;

import edu.famu.cop3060.yard.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<Opportunity, String> {
}