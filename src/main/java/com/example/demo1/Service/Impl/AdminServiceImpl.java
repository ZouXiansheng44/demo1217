package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.AdminDao;
import com.example.demo1.Data.Admin;
import com.example.demo1.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin findByAdminNameAndAdminPassword(String adminName, String adminPassword) {
        return adminDao.findByAdminNameAndAdminPassword(adminName,adminPassword);
    }
}
