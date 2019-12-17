package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.AnswerDao;
import com.example.demo1.Data.Answer;
import com.example.demo1.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerDao answerDao;
    @Override
    public List<Answer> findAll()
    {
        return answerDao.findAll();
    }

    @Override
    public Answer findByAnalysisId(Integer analysisId) {
        return answerDao.findByAnalysisId(analysisId);
    }

    @Override
    public Answer save(Answer answer) {
        return answerDao.save(answer);
    }

    @Override
    public Answer findByQuestionId(Integer questionId) {
        return answerDao.findByQuestionId(questionId);
    }


}
