package com.borowskiadam.todosbackend.rest;


import com.borowskiadam.todosbackend.entity.Todo;
import com.borowskiadam.todosbackend.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {

    private ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public List<Todo> findAll() {
        return this.toDoService.findAll();
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo theToDo) {
        theToDo.setId(0);
        this.toDoService.save(theToDo);
        return theToDo;
    }

    @GetMapping("/todo/{toDoId}")
    public Todo getToDo(@PathVariable int toDoId) {
        Todo theToDo = this.toDoService.findById(toDoId);
        if (theToDo == null) {
            throw new RuntimeException("The is not todo with such id - " + toDoId);
        }
        return theToDo;
    }

    @PutMapping("/todo")
    public Todo update(@RequestBody Todo theToDo) {
        this.toDoService.save(theToDo);
        return theToDo;
    }

    @DeleteMapping("/todo/{todoId}")
    public String deleteTodo(@PathVariable int todoId) {
        Todo tempTodo = this.toDoService.findById(todoId);
        if (tempTodo == null) {
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }
        this.toDoService.deleteById(todoId);
        return "todo with Id  : " + todoId + " deleted";
    }

}
