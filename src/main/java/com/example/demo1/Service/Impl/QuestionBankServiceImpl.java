package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.QuestionBankDao;
import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    @Autowired
    private QuestionBankDao questionBankDao;
    @Override
    public QuestionBank save(QuestionBank questionBank) {
        return questionBankDao.save(questionBank);
    }

    @Override
    public Page<QuestionBank> findAll(Pageable pageable) {
        Page<QuestionBank> questionBankDaoAll = questionBankDao.findAll(pageable);
        return questionBankDaoAll;
    }

    @Override
    public Page<QuestionBank> findByQuestionId(Pageable pageable, Integer questionId) {
        Page<QuestionBank> questionBankList = questionBankDao.findByQuestionId(pageable,questionId);
        return questionBankList;
    }

    @Override
    public QuestionBank findOne(Integer questionId) {
        QuestionBank byQuestionId = questionBankDao.findByQuestionId(questionId);
        return byQuestionId;
    }
}
