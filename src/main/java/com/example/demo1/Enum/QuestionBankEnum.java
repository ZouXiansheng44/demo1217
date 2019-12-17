package com.example.demo1.Enum;

import lombok.Getter;

@Getter
public enum QuestionBankEnum implements CodeEnum {
    SingleChoice("0","判断题"),
    MultipleChoice("1","多选题"),
    WrongQuestions("2","单选题");
    ;
    private String code;
    private String msg;

    QuestionBankEnum(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

}
