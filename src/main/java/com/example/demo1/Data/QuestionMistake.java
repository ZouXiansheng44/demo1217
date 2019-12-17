package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 错题表
 */
@Data
@Entity
@Table(name = "question_mistake")
@DynamicUpdate
@DynamicInsert
public class QuestionMistake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mistakeId;//错题ID
    private Integer questionId;//题目ID
    private Integer userId;//用户ID
    private Integer mistakeStatus;//错题状态（0非错题/错题1）
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

}
