package com.example.demo1.Dao;

import com.example.demo1.Data.QuestionFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QuestionFeedbackDao extends JpaRepository<QuestionFeedback,String>, JpaSpecificationExecutor<QuestionFeedback> {

}
