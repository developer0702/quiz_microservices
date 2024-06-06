package com.Questions.services;

import com.Questions.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> getAll();

    Question getOne(Long questionId);

    List<Question> getQuestionOfQuiz(Long quizId);

}
