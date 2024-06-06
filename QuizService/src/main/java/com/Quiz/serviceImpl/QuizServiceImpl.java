package com.Quiz.serviceImpl;

import com.Quiz.entities.Quiz;
import com.Quiz.repositories.QuizRepository;
import com.Quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    private  QuestionClient questionClient;
    @Override
    public Quiz add(Quiz quiz) {

        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
       Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("quiz not found "));

       quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
       return quiz;
    }


}
