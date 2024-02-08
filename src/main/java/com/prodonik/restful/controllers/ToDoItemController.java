package com.prodonik.restful.controllers;

import com.prodonik.restful.models.ToDoItem;
import com.prodonik.restful.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
