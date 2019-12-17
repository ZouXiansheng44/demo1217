package com.example.demo1.Dao;

import com.example.demo1.Data.QuestionCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QuestionCollectDao extends JpaRepository<QuestionCollect,String>, JpaSpecificationExecutor<QuestionCollect> {
    Long countByQuestionIdAndCollectStatus(Integer questionId, Integer collectStatus);
}
