package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.AnswerDao;
import com.example.demo1.Data.Answer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class AnswerServiceImplTest {
    @Autowired
    AnswerServiceImpl answerService;
    @Test
    void findByAnalysisId() {
        Answer byAnalysisId = answerService.findByAnalysisId(1);
        System.out.println(byAnalysisId);
    }
}