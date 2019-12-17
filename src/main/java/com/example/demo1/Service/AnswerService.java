package com.example.demo1.Service;

import com.example.demo1.Data.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAll();

    Answer findByAnalysisId(Integer analysisId);

    Answer save(Answer answer);

    Answer findByQuestionId(Integer questionId);

}
