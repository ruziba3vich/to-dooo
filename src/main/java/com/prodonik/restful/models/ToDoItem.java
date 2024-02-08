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
    private Status status;

    public ToDoItem (
        String title, String description, Status status
    ) {
        this.createdOn = LocalDateTime.now();
        this.setTitle(title);
        this.setDescription(description);
        this.setStatus(status);
    }

    public Long getId () {
        return this.id;
    }

    public ToDoItem() {
        this.createdOn = LocalDateTime.now();
    }
    

    public  LocalDateTime getCreatedDateTime () {
        return this.createdOn;
    }

    public void setUpdatedDateTime (LocalDateTime newUpdatedTime) {
        this.updatedOn = newUpdatedTime;
    }
    public LocalDateTime getUpdatedDateTime () {
        return this.updatedOn;
    }

    public void setTitle (String title) {
        this.title = title;
    }
    public String getTitle () {
        return this.title;
    }

    public void setDescription (String description) {
        this.description = description;
    }
    public String getDescription () {
        return this.description;
    }

    public void setStatus (Status status2) {
        this.status = status2;
    }
    public Status getStatus () {
        return this.status;
    }
}
