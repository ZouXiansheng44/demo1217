package com.example.demo1.Service;


import com.example.demo1.Data.QuestionCollect;

import java.util.List;

public interface QuestionCollectService {
    List<QuestionCollect> findAll();

    Long countByQuestionIdAndCollectStatus(Integer questionId, Integer collectStatus);
}
