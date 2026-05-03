package edu.famu.cop3060.yard.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public class UpdateOpportunityDTO {

    @NotBlank
    @Size(max = 120)
    private String title;

    @NotBlank
    private String type;

    @NotBlank
    private String sponsor;

    @NotBlank
    private String deadline;

    @NotBlank
    @Size(max = 500)
    private String description;

    @NotNull
    @Size(min = 1)
    private List<String> tags;

    @NotBlank
    @Pattern(regexp = "https?://.*")
    private String url;

    // getters & setters
}