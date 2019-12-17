package com.example.demo1.Service;

import com.example.demo1.Data.QuestionBank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QuestionBankService {
    QuestionBank save(QuestionBank questionBank);

    Page<QuestionBank>findAll(Pageable pageable);

    Page<QuestionBank> findByQuestionId(Pageable pageable, Integer questionId);

    QuestionBank findOne(Integer questionId);
}
