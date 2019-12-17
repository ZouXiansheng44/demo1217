package com.example.demo1.form;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionBankForm {
    private Integer questionId;//题目ID
    private String questionContent;//题目内容
    private String questionOption;//题目选项
    private String questionAnswer;//答案
    private String questionType;//题目类型
    private String questionSubject;//科目
    //private Integer questionStatus;//题目状态（0发布／1未发布）
}
