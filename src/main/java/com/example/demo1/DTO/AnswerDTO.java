package com.example.demo1.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerDTO {
    private Integer questionId;//题目ID
    private Integer analysisId;//解析ID
    private String analysisContent;//解析内容
    private String questionContent;//题目内容
    private Date createTime;
}
