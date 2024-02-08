package com.prodonik.restful.controllers;

import com.prodonik.restful.models.Status;
import com.prodonik.restful.models.ToDoItem;
import com.prodonik.restful.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @GetMapping
    public List<ToDoItem> getAllToDoItems() {
        return toDoItemService.getAllToDoItems();
    }

    @GetMapping("/{id}")
    public ToDoItem getToDoItemById(@PathVariable Long id) {
        return toDoItemService.getToDoItemById(id);
    }

    @PostMapping
    public ToDoItem createToDoItem(@RequestBody ToDoItem toDoItem) {
        return toDoItemService.saveToDoItem(toDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable Long id) {
        toDoItemService.deleteToDoItem(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateToDoItemStatus(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String statusString = requestBody.get("status");
        if (statusString == null) {
            return ResponseEntity.badRequest().body("Status parameter is missing in the request body");
        }
        
        Status status;
        try {
            status = Status.valueOf(statusString);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status value");
        }

        boolean updated = toDoItemService.updateToDoItemStatus(id, status);
        if (updated) {
            return ResponseEntity.ok().body("Status updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
