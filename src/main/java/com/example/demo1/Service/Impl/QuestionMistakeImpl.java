package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.QuestionMistakeDao;
import com.example.demo1.Data.QuestionMistake;
import com.example.demo1.Service.QuestionMistakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionMistakeImpl implements QuestionMistakeService {
    @Autowired
    QuestionMistakeDao questionMistake;
    @Override
    public Long countByQuestionIdAndMistakeStatus(Integer questionId, Integer mistakeStatus) {
        return questionMistake.countByQuestionIdAndMistakeStatus(questionId,mistakeStatus);
    }

    @Override
    public List<QuestionMistake> findAll() {
        return questionMistake.findAll();
    }


}
