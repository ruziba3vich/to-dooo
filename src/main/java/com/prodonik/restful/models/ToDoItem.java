package com.prodonik.restful.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record ToDoItem(
    UUID id,
    LocalDateTime createdOn,
    LocalDateTime updatedOn,
    String title,
    String description,
    String status
) {
    
}
