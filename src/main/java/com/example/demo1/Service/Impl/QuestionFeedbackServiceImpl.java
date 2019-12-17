package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.QuestionFeedbackDao;
import com.example.demo1.Data.QuestionFeedback;
import com.example.demo1.Service.QuestionFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionFeedbackServiceImpl implements QuestionFeedbackService {
    @Autowired
    QuestionFeedbackDao questionFeedbackDao;

    @Override
    public Page<QuestionFeedback> findAll(Pageable pageable) {
        return questionFeedbackDao.findAll(pageable);
    }
}
