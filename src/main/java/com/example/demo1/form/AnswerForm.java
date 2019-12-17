package com.example.demo1.form;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerForm {
    private Integer analysisId;//解析ID
    private Integer questionId;//题目ID
    private String analysisContent;//解析内容
}
