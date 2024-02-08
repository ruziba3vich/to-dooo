package com.prodonik.restful.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String title;
    private String description;
    private String status;

    public ToDoItem (
        String title, String description, String status
    ) {
        this.createdOn = LocalDateTime.now();
        this.setTitle(title);
        this.setDescription(description);
        this.setStatus(status);
    }

    public  LocalDateTime getCreatedDateTime () {
        return createdOn;
    }

    public void setUpdatedDateTime (LocalDateTime newUpdatedTime) {
        this.updatedOn = newUpdatedTime;
    }
    public LocalDateTime getUpdatedDateTime () {
        return updatedOn;
    }

    public void setTitle (String title) {
        this.title = title;
    }
    public String getTitle () {
        return title;
    }

    public void setDescription (String description) {
        this.description = description;
    }
    public String getDescription () {
        return description;
    }

    public void setStatus (String status) {
        this.status = status;
    }
    public String getStatus () {
        return status;
    }
}
