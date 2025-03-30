package com.spider.spider.controller;

import com.spider.spider.model.TodoEntity;
import com.spider.spider.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoEntity createTodo(@RequestBody TodoEntity todo){
        return todoService.saveTodo(todo);
    }
    @GetMapping
    public List<TodoEntity> getAllTodos() {
        return todoService.getAllTodo();
    }

    @PutMapping("/{id}")
    public TodoEntity updateTodo(@PathVariable Long id,@RequestBody TodoEntity todo){
        return todoService.updateTodo(id,todo);
    }
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
         todoService.deleteTodo(id);
        return "Todo with ID " + id + " deleted successfully!";
    }

}
