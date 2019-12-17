package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.UserGradeDao;
import com.example.demo1.Data.UserGrade;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class UserGradeServiceImplTest {

    @Autowired
    UserGradeDao service;

    @Test
    void findByUserId() {
        Integer page=1;
        Integer size=1;
        Page<UserGrade> byUserId = service.findByUserId(PageRequest.of(page - 1, size), 1);
        System.out.println(byUserId);
    }
}