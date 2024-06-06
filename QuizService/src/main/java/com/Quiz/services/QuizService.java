package com.Quiz.services;

import com.Quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add (Quiz quiz);
    List<Quiz> get();
    Quiz get(Long id);
}
