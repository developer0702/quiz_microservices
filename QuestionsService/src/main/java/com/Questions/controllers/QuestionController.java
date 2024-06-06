package com.Questions.controllers;


import com.Questions.entities.Question;
import com.Questions.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return  this.questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return  questionService.getAll();
    }

    @GetMapping("/{questionId}")
    public  Question getOne(@PathVariable Long questionId){
        return  questionService.getOne(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public  List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
        return  questionService.getQuestionOfQuiz(quizId);
    }
}
