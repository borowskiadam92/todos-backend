package com.borowskiadam.todosbackend.service;

import com.borowskiadam.todosbackend.entity.Todo;

import java.util.List;

public interface ToDoService {

    List<Todo> findAll();

    Todo findById(int theId);

    void save(Todo todo);

    String deleteById(int theId);
}
