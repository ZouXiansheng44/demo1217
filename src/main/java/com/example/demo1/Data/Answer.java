package com.example.demo1.Data;
/**
 * 答案表
 */
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "answer_analysis")
@DynamicUpdate
@DynamicInsert
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer analysisId;//解析ID
    private Integer questionId;//题目ID
    private String analysisContent;//解析内容
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

}