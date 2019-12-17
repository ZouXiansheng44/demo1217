package com.example.demo1.Service;

import com.example.demo1.Data.UserGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserGradeService {
    Page<UserGrade> findByUserId (Pageable pageable, Integer userId);
}
