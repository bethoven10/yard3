package edu.famu.cop3060.yard;

import edu.famu.cop3060.yard.controller.OpportunitiesController;
import edu.famu.cop3060.yard.dto.OpportunityDTO;
import edu.famu.cop3060.yard.service.OpportunitiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OpportunitiesController.class)
public class OpportunitiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpportunitiesService service;

    // ✅ TEST 1: List endpoint
    @Test
    void testGetAllOpportunities() throws Exception {

        List<OpportunityDTO> mockList = List.of(
                new OpportunityDTO("opp-001", "Test Opp 1", "Scholarship",
                        "Test", "2025-01-01", "Desc",
                        List.of("STEM"), "url"),

                new OpportunityDTO("2", "Test Opp 2", "Internship",
                        "Test", "2025-02-01", "Desc",
                        List.of("tech"), "url")
        );

        when(service.getOpportunities(null, null)).thenReturn(mockList);

        mockMvc.perform(get("/api/opportunities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Test Opp 1"));
    }

    // ✅ TEST 2: Get by ID
    @Test
    void testGetOpportunityById() throws Exception {

        OpportunityDTO mockOpp = new OpportunityDTO(
                "1", "UNCF STEM Scholarship", "Scholarship",
                "UNCF", "2025-04-15", "Desc",
                List.of("STEM"), "url"
        );

        when(service.getOpportunityById("opp-001")).thenReturn(Optional.of(mockOpp));

        mockMvc.perform(get("/api/opportunities/opp-001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("UNCF STEM Scholarship"));
    }

    // ⭐ BONUS TEST: 404
    @Test
    void testGetOpportunityNotFound() throws Exception {

        when(service.getOpportunityById("999")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/opportunities/999"))
                .andExpect(status().isNotFound());
    }
}