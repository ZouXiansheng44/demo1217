package com.example.demo1.Service.Impl;

import com.example.demo1.Data.QuestionCollect;
import com.example.demo1.Service.QuestionCollectService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionCollectImplTest {
    @Autowired
    QuestionCollectService questionCollectService;
    @Test
    void countByQuestionIdAndCollectStatus() {
        Long aLong = questionCollectService.countByQuestionIdAndCollectStatus(1, 1);
        System.out.println(aLong);
    }
}