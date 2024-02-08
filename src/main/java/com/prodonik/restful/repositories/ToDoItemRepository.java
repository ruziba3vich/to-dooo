package com.prodonik.restful.repositories;

import com.prodonik.restful.models.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
