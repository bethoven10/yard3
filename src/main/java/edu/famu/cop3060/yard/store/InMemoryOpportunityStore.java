package edu.famu.cop3060.yard.store;

import edu.famu.cop3060.yard.dto.OpportunityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryOpportunityStore {

    private static final Logger logger =
            LoggerFactory.getLogger(InMemoryOpportunityStore.class);

    private final Map<String, OpportunityDTO> map = new HashMap<>();
    private final List<OpportunityDTO> list = new ArrayList<>();

    public InMemoryOpportunityStore() {

        seed(new OpportunityDTO("opp-001", "UNCF STEM Scholarship", "Scholarship",
                "UNCF", "2025-04-15", "STEM support scholarship",
                List.of("STEM", "undergrad", "paid"),
                "https://uncf.org"));

        seed(new OpportunityDTO("opp-002", "Google HBCU Residency", "Fellowship",
                "Google", "2025-06-01", "Tech fellowship program",
                List.of("tech", "paid", "summer"),
                "https://google.com"));

        seed(new OpportunityDTO("opp-003", "NSBE Chapter", "Organization",
                "NSBE", "N/A", "Engineering student org",
                List.of("engineering", "networking", "STEM"),
                "https://nsbe.org"));

        seed(new OpportunityDTO("opp-004", "Homecoming Step Show", "Event",
                "Campus Life", "2025-10-01", "Campus performance event",
                List.of("culture", "campus"),
                "https://campus.edu"));

        seed(new OpportunityDTO("opp-005", "Goldman Sachs Internship", "Internship",
                "Goldman Sachs", "2025-05-01", "Finance internship",
                List.of("finance", "paid", "junior"),
                "https://goldmansachs.com"));

        seed(new OpportunityDTO("opp-006", "Meta Software Internship", "Internship",
                "Meta", "2025-05-10", "Software engineering internship",
                List.of("tech", "paid"),
                "https://meta.com"));

        seed(new OpportunityDTO("opp-007", "Black Student Union", "Organization",
                "BSU", "N/A", "Student cultural org",
                List.of("culture", "community"),
                "https://bsu.org"));

        seed(new OpportunityDTO("opp-008", "Resume Workshop", "Event",
                "Career Center", "2025-03-20", "Career prep workshop",
                List.of("career", "professional"),
                "https://career.edu"));

        logger.info("Seeded {} opportunities into the in-memory store.", list.size());
    }

    private void seed(OpportunityDTO opp) {
        map.put(opp.getId(), opp);
        list.add(opp);
    }

    // 1. return all (unmodifiable)
    public List<OpportunityDTO> findAll() {
        return Collections.unmodifiableList(list);
    }

    // 2. find by ID
    public Optional<OpportunityDTO> update(String id, OpportunityDTO updated) {
        if (!map.containsKey(id)) {
            return Optional.empty();
        }

        map.put(id, updated);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, updated);
                break;
            }
        }

        return Optional.of(updated);
    }

    // 3. filter method
    public List<OpportunityDTO> findFiltered(String type, String q) {

        return list.stream()
                .filter(o -> type == null || o.getType().equalsIgnoreCase(type))
                .filter(o -> q == null ||
                        o.getTitle().toLowerCase().contains(q.toLowerCase()) ||
                        o.getTags().stream().anyMatch(t -> t.toLowerCase().contains(q.toLowerCase()))
                )
                .collect(Collectors.toList());


    }
    public OpportunityDTO create(OpportunityDTO opportunity) {
        map.put(opportunity.getId(), opportunity);
        list.add(opportunity);
        return opportunity;
    }
    public boolean delete(String id) {
        if (!map.containsKey(id)) {
            return false;
        }

        map.remove(id);
        list.removeIf(o -> o.getId().equals(id));

        return true;
    }

    public Optional<OpportunityDTO> findById(String id){
        return Optional.ofNullable(map.get(id));
    }


}
