package com.borowskiadam.todosbackend.dao;

import com.borowskiadam.todosbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository <Todo,Integer> {

}
