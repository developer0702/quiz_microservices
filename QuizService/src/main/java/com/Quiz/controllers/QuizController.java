package com.Quiz.controllers;

import com.Quiz.entities.Quiz;
import com.Quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return  quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return  quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id) ;
    }
}
