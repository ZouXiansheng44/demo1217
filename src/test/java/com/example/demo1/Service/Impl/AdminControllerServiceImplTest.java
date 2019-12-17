package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.AdminDao;
import com.example.demo1.Data.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class AdminControllerServiceImplTest {
    @Autowired
    private AdminServiceImpl adminDao;
    @Test
    public void findByAdminNameAndAdminPassword() {
        Admin admin = adminDao.findByAdminNameAndAdminPassword("hh", "123");
        System.out.println(admin);
    }
}