package com.example.demo1.Controller;

import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Enum.QuestionBankEnum;
import com.example.demo1.Service.QuestionBankService;
import com.example.demo1.Util.EnumUtil;
import com.example.demo1.form.QuestionBankForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Admin/Question")
public class QuestionBankController {
    @Autowired
    QuestionBankService questionBankService;
    //所有题目
    @RequestMapping("/List")
    private ModelAndView List(@RequestParam(value = "page",defaultValue = "1")Integer page,
                              @RequestParam(value = "size",defaultValue = "10")Integer size,
                              Map<String,Object> map){
        Page<QuestionBank> questionBankServiceAll = questionBankService.findAll(PageRequest.of(page - 1, size));
        map.put("questionBankPage",questionBankServiceAll);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("content/List",map);
    }

    //根据ID找出单个题目
    @RequestMapping("/findById")
    private ModelAndView findById(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                  @RequestParam(value = "size",defaultValue = "10")Integer size,
                                  Integer questionId,
                                  Map<String,Object> map){
        if (questionId == null){
            map.put("msg","搜索内容为空");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("content/blink",map);
        }
        Page<QuestionBank> questionBankPage= questionBankService.findByQuestionId(PageRequest.of(page - 1, size),questionId);
        map.put("questionBankPage",questionBankPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("content/List",map);
    }


    //更新已存在的题目
    @RequestMapping("/Update")
    private ModelAndView update(@Valid QuestionBankForm questionBankForm, Map<String,Object> map){
        QuestionBank questionBank=new QuestionBank();
        try {
            if(!StringUtils.isEmpty(questionBankForm.getQuestionId())){
               questionBank=questionBankService.findOne(questionBankForm.getQuestionId());
            }
            if (!questionBankForm.getQuestionType().equals(EnumUtil.getEnumByCode(questionBankForm.getQuestionType(),QuestionBankEnum.class).getCode())){
                map.put("msg","保存失败,输入的题目类型不存在!!!");
                map.put("url","/Admin/Question/Detail?questionId="+ questionBankForm.getQuestionId());
                return new ModelAndView("content/error",map);
            }
            BeanUtils.copyProperties(questionBankForm,questionBank);
            questionBankService.save(questionBank);
        }catch (Exception e){
            map.put("msg","保存失败!!!");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("content/error",map);
        }
        map.put("msg","保存成功!!!");
        map.put("url","/Admin/Question/List");
        return new ModelAndView("content/success",map);
    }

    //单个题目详细信息
    @RequestMapping("/Detail")
    private ModelAndView detail(@RequestParam(value = "questionId" ,required = false)Integer questionId,
                                Map<String,Object> map){
        try {
            if (!StringUtils.isEmpty(questionId)){
                QuestionBank questionDetail = questionBankService.findOne(questionId);
                map.put("questionDetail",questionDetail);
            }
        }catch (Exception e){
            map.put("msg","查找失败!!!");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("content/error",map);
        }
        return new ModelAndView("content/Detail",map);
    }

    //更改状态
    @RequestMapping("/Status")
    private ModelAndView status(Map<String,Object> map,
                                Integer questionId){
        QuestionBank questionBank=questionBankService.findOne(questionId);
        try {
            if (questionBank.getQuestionStatus()==0){
                questionBank.setQuestionStatus(1);
            }else {
                questionBank.setQuestionStatus(0);
            }
            questionBankService.save(questionBank);
        }catch (Exception e){
            map.put("msg","修改失败");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("content/error",map);
        }
        map.put("msg","修改成功");
        map.put("url","/Admin/Question/List");
        return new ModelAndView("content/success",map);
    }
}
