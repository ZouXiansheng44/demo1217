package com.example.demo1.Service;


import com.example.demo1.Data.QuestionMistake;

import java.util.List;

public interface QuestionMistakeService  {
    Long countByQuestionIdAndMistakeStatus(Integer questionId, Integer mistakeStatus);

    List<QuestionMistake> findAll();
}
