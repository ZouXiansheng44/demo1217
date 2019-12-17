package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "question_collect")
@DynamicInsert
@DynamicUpdate
public class QuestionCollect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer collectId;
    private Integer questionId;
    private Integer userId;
    private Integer collectStatus;
    private Date createTime;
    private Date updateTime;

}
