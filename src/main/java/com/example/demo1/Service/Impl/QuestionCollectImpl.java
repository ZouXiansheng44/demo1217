package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.QuestionCollectDao;
import com.example.demo1.Data.QuestionCollect;
import com.example.demo1.Service.QuestionCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionCollectImpl implements QuestionCollectService {
    @Autowired
    private QuestionCollectDao questionCollectDao;
    @Override
    public List<QuestionCollect> findAll() {
        return questionCollectDao.findAll();
    }

    @Override
    public Long countByQuestionIdAndCollectStatus(Integer questionId, Integer collectStatus) {
        return questionCollectDao.countByQuestionIdAndCollectStatus(questionId,collectStatus);
    }


}
