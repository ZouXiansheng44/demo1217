package com.example.demo1.Data;
/**
 * 题目表
 */
import com.example.demo1.Enum.QuestionBankEnum;
import com.example.demo1.Util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "question_bank")
@DynamicUpdate
@DynamicInsert
public class QuestionBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;//题目ID
    private String questionContent;//题目内容
    private String questionOption;//题目选项
    private String questionAnswer;//答案
    private String questionType;//题目类型
    private String questionSubject;//科目
    private Integer questionStatus;//题目状态（0发布／1未发布）
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    @JsonIgnore
    public QuestionBankEnum getQuestionType(){
        return EnumUtil.getEnumByCode(questionType,QuestionBankEnum.class);
    }
}
