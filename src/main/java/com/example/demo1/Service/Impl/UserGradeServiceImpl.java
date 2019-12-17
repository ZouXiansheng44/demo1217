package com.example.demo1.Service.Impl;

import com.example.demo1.Dao.UserGradeDao;
import com.example.demo1.Data.UserGrade;
import com.example.demo1.Service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserGradeServiceImpl implements UserGradeService {
    @Autowired
    UserGradeDao userGradeDao;

    @Override
    public Page<UserGrade> findByUserId(Pageable pageable,Integer userId) {
        return userGradeDao.findByUserId(pageable,userId);
    }
}
