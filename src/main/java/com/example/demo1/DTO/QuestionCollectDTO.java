package com.example.demo1.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionCollectDTO {
    private Integer questionId;

    private String questionContent;

    private Date createTime;

    private Long count;


}
