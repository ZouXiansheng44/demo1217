package com.example.demo1.Dao;

import com.example.demo1.Data.QuestionMistake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QuestionMistakeDao extends JpaRepository<QuestionMistake,String>, JpaSpecificationExecutor<QuestionMistake> {
    Long countByQuestionIdAndMistakeStatus(Integer questionId, Integer mistakeStatus);
}
