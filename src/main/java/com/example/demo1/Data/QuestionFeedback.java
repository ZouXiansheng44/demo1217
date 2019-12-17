package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "question_feedback")
@DynamicUpdate
@DynamicInsert
@Entity
public class QuestionFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    private Integer question_id;
    private Integer user_id;
    private String user_name;
    private String feedback_content;
    private Date create_time;
    private Date update_time;

}
