package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "user_grade")
@DynamicUpdate
@DynamicInsert
@Entity
public class UserGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;
    private Integer userId;
    private Integer gradeValue;
    private String questionSubject;
    private Date createTime;
    private Date updateTime;
}
