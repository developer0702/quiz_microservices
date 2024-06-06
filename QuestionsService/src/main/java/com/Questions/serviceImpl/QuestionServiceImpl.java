package com.Questions.serviceImpl;

import com.Questions.entities.Question;
import com.Questions.repositories.QuestionRepository;
import com.Questions.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne( Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("question not found"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {

        return questionRepository.findByQuizId(quizId);
    }
}
