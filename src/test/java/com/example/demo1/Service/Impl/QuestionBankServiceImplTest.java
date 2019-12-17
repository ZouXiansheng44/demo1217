package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.QuestionBankDao;
import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Enum.QuestionBankEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.tree.VoidDescriptor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionBankServiceImplTest {
    @Autowired
    QuestionBankDao questionBankDao;
    @Test
    public void saveTest() {
        QuestionBank questionBank= new QuestionBank();
        questionBank.setQuestionContent("1+9=()");
        questionBank.setQuestionOption("10※20※50※30");
        questionBank.setQuestionAnswer("A");
        questionBank.setQuestionType(QuestionBankEnum.MultipleChoice.getMsg());
        questionBank.setQuestionSubject("数学");
        questionBank.setQuestionStatus(0);
        QuestionBank res= questionBankDao.save(questionBank);
        System.out.println(res);
        Assert.assertNotNull(res);
    }
    @Test
    public void findAll(){
        List<QuestionBank> list = questionBankDao.findAll();
        for (QuestionBank obj : list){
            System.out.println(obj);
        }
    }
    @Test
    public void findOne(){
        Integer page=1;
        Integer size=5;
        Page<QuestionBank> list =questionBankDao.findByQuestionId(PageRequest.of(page - 1, size),1);
        System.out.println(list.getContent());
    }
}