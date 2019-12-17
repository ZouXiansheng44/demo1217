package com.example.demo1.Service;

import com.example.demo1.Data.QuestionFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionFeedbackService {
    Page<QuestionFeedback> findAll(Pageable pageable);
}
