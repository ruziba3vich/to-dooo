package com.prodonik.restful.services;

import com.prodonik.restful.models.ToDoItem;
import com.prodonik.restful.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> getAllToDoItems() {
        return toDoItemRepository.findAll();
    }

    @SuppressWarnings("null")
    public ToDoItem getToDoItemById(Long id) {
        return toDoItemRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public ToDoItem saveToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @SuppressWarnings("null")
    public void deleteToDoItem(Long id) {
        toDoItemRepository.deleteById(id);
    }
}
