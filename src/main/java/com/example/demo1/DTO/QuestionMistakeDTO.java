package com.example.demo1.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionMistakeDTO {

    private Integer questionId;//题目ID

    private String questionContent;//题目内容

    private Date createTime;//创建时间

    private Long count;//数量
}
