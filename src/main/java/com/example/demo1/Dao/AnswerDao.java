package com.example.demo1.Dao;

import com.example.demo1.Data.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnswerDao extends JpaRepository<Answer,String>, JpaSpecificationExecutor<Answer> {
    Answer findByAnalysisId(Integer analysisId);

    Answer findByQuestionId(Integer questionId);
}
