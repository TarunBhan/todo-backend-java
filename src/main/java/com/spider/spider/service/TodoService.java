package com.spider.spider.service;

import com.spider.spider.model.TodoEntity;
import com.spider.spider.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoEntity saveTodo(TodoEntity todo){
        return todoRepository.save(todo);
    }
    public List<TodoEntity> getAllTodo(){
        return todoRepository.findAll();
    }

    public TodoEntity updateTodo(Long id, TodoEntity updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
           return  todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public void deleteTodo(Long id){
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw  new RuntimeException("Todo not found");
        }

    }
}
