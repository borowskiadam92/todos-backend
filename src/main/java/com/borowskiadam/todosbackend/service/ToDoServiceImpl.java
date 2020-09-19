package com.borowskiadam.todosbackend.service;

import com.borowskiadam.todosbackend.dao.ToDoRepository;
import com.borowskiadam.todosbackend.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private  ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return this.toDoRepository.findAll();
    }

    @Override
    public Todo findById(int theId)  {
        Optional<Todo> result = this.toDoRepository.findById(theId);
        Todo theToDo = null;
        if(result.isPresent()){
            theToDo=result.get();
        }else{
            throw new RuntimeException("Did not find any TODO with id - " + theId);
        }
         return theToDo;
    }

    @Override
    public void save(Todo todo) {
        this.toDoRepository.save(todo);

    }

    @Override
    public String deleteById(int theId) {
        this.toDoRepository.deleteById(theId);

        return null;
    }
}
