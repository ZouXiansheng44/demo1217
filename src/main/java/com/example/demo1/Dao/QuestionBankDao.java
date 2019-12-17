package com.example.demo1.Dao;

import com.example.demo1.Data.QuestionBank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface QuestionBankDao extends JpaRepository<QuestionBank,String>, JpaSpecificationExecutor<QuestionBank> {

    Page<QuestionBank> findByQuestionId(Pageable pageable, Integer questionId);

    QuestionBank findByQuestionId(Integer questionId);
}
