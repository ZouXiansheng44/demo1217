package com.example.demo1.Controller;


import com.example.demo1.DTO.AnswerDTO;
import com.example.demo1.Data.Answer;
import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Service.AnswerService;
import com.example.demo1.Service.Impl.AnswerServiceImpl;
import com.example.demo1.Service.Impl.QuestionBankServiceImpl;
import com.example.demo1.form.AnswerForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Admin/Answer")
public class AnswerController {
    @Autowired
    AnswerServiceImpl answerService;
    @Autowired
    QuestionBankServiceImpl questionBankService;
    @RequestMapping("/Analysis")
    private ModelAndView answer_analysis(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")Integer size,
                                         Map<String,Object> map){
        List<Answer> all = answerService.findAll();
        List<AnswerDTO> answerDTOS=new ArrayList<>();
        for(Answer answers : all){
            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setAnalysisContent(answers.getAnalysisContent());
            answerDTO.setAnalysisId(answers.getAnalysisId());
            QuestionBank banks = questionBankService.findOne(answers.getQuestionId());
            answerDTO.setQuestionId(banks.getQuestionId());
            answerDTO.setQuestionContent(banks.getQuestionContent());
            answerDTO.setCreateTime(banks.getCreateTime());
            answerDTOS.add(answerDTO);
        }
        Page<AnswerDTO> answerDTOPage=new PageImpl<>(answerDTOS,PageRequest.of(page - 1, size),size);
        map.put("answerDTOPage",answerDTOPage);
        map.put("size",size);
        map.put("currentPage",page);
      return new ModelAndView("Answer/Answer",map);
    }

    @RequestMapping("/FindById")
    private  ModelAndView findById(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                   @RequestParam(value = "size",defaultValue = "10")Integer size,
                                   Integer questionId,
                                   Map<String,Object> map){
        try {
            if(questionId==null){
                map.put("msg","搜索内容为空");
                map.put("url","/Admin/Answer/Analysis");
                return new ModelAndView("content/blink",map);
            }
            Answer answer=answerService.findByQuestionId(questionId);
            QuestionBank questionBank= questionBankService.findOne(questionId);
            AnswerDTO answerDTO =new AnswerDTO();
            answerDTO.setQuestionId(questionId);
            answerDTO.setAnalysisId(answer.getAnalysisId());
            answerDTO.setAnalysisContent(answer.getAnalysisContent());
            answerDTO.setQuestionContent(questionBank.getQuestionContent());
            answerDTO.setCreateTime(questionBank.getCreateTime());
            List<AnswerDTO> answerDTOS=new ArrayList<>();
            answerDTOS.add(answerDTO);
            Page<AnswerDTO> answerDTOPage=new PageImpl<>(answerDTOS,PageRequest.of(page - 1, size),size);
            map.put("answerDTOPage",answerDTOPage);
        }catch (Exception e){
            map.put("msg","数据不存在!!!");
            map.put("url","/Admin/Answer/Analysis");
            return new ModelAndView("content/error",map);
        }
        map.put("size",size);
        map.put("currentPage",page);
        return new ModelAndView("Answer/Answer",map);
    }

    @RequestMapping("/Detail")
    private ModelAndView detail(@RequestParam(value = "analysisId" ,required = false)Integer analysisId,
                                Map<String,Object> map){
        try {
            if(!StringUtils.isEmpty(analysisId)){
                Answer byAnalysisId = answerService.findByAnalysisId(analysisId);
                map.put("answer",byAnalysisId);
            }
        }catch (Exception e){
            map.put("msg","数据不存在!!!");
            map.put("url","/Admin/Answer/Analysis");
            return new ModelAndView("content/error",map);
        }
    return new ModelAndView("Answer/Detail",map);
    }

    @RequestMapping("/Update")
    private ModelAndView update(@Valid AnswerForm answerForm,
                                Map<String,Object> map){
        Answer answer=new Answer();
        try {
            if (!StringUtils.isEmpty(answerForm.getAnalysisId())){
                answer = answerService.findByAnalysisId(answerForm.getAnalysisId());
            }
            BeanUtils.copyProperties(answerForm,answer);
            answerService.save(answer);
        }catch (Exception e){
            map.put("msg","保存失败!!!可能解析已存在!!!");
            map.put("url","/Admin/Answer/Analysis");
            return new ModelAndView("content/error",map);
        }
        map.put("msg","保存成功!!!");
        map.put("url","/Admin/Answer/Analysis");
        return new ModelAndView("content/success",map);
    }

}
