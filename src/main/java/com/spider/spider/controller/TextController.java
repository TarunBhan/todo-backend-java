package com.spider.spider.controller;

import com.spider.spider.dto.TextRequest;
import com.spider.spider.model.TextEntity;
import com.spider.spider.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
@ControllerAdvice
@RestController

@RequestMapping("/text")
public class TextController {
    @Autowired
    private TextService textService;

    // Store a text value
    @PostMapping
    public TextEntity storeText(@RequestBody TextRequest request) {
        return textService.saveText(request.getValue());
    }

    @DeleteMapping("/{id}")
    public String deleteText(@PathVariable Long id) {
        return textService.deleteText(id);
    }

    // Get all stored text values
    @ExceptionHandler({NoHandlerFoundException.class})
    @GetMapping
    public List<TextEntity> getAllTexts() {
        return textService.getAllTexts();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Falcon!";
    }
}
