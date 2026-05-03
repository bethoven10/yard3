package edu.famu.cop3060.yard.dto;

import java.util.List;

public class OpportunityDTO {

    private String id;
    private String title;
    private String type;
    private String sponsor;
    private String deadline;
    private String description;
    private List<String> tags;
    private String url;

    // REQUIRED: no-args constructor for Spring/Jackson
    public OpportunityDTO() {
    }

    // Constructor WITHOUT id (used for POST / create)
    public OpportunityDTO(String title, String type, String sponsor,
                          String deadline, String description,
                          List<String> tags, String url) {
        this.title = title;
        this.type = type;
        this.sponsor = sponsor;
        this.deadline = deadline;
        this.description = description;
        this.tags = tags;
        this.url = url;
    }

    // Full constructor (useful for mapping responses)
    public OpportunityDTO(String id, String title, String type, String sponsor,
                          String deadline, String description,
                          List<String> tags, String url) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.sponsor = sponsor;
        this.deadline = deadline;
        this.description = description;
        this.tags = tags;
        this.url = url;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}