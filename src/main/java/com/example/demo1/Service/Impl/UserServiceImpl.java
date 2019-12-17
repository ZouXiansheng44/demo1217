package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.UserDao;
import com.example.demo1.Data.User;
import com.example.demo1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
