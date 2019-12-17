package com.example.demo1.Dao;

import com.example.demo1.Data.UserGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserGradeDao extends JpaRepository<UserGrade,String>, JpaSpecificationExecutor<UserGrade> {
        Page<UserGrade> findByUserId (Pageable pageable, Integer userId);
}
