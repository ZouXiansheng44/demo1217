package com.example.demo1.Controller;

import com.example.demo1.DTO.QuestionCollectDTO;
import com.example.demo1.DTO.QuestionMistakeDTO;
import com.example.demo1.Dao.QuestionMistakeDao;
import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Data.QuestionMistake;
import com.example.demo1.Service.Impl.QuestionBankServiceImpl;
import com.example.demo1.Service.Impl.QuestionMistakeImpl;
import com.example.demo1.Service.QuestionMistakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Admin/Mistake")
public class QuestionMistakeController {
    @Autowired
    QuestionMistakeImpl questionMistake;
    @Autowired
    QuestionBankServiceImpl questionBankService;
    @RequestMapping("/List")
    private ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                              @RequestParam(value = "size",defaultValue = "10")Integer size,
                              Map<String,Object> map){
        try {
            List<QuestionMistake> mistakeAll = questionMistake.findAll();
            List<QuestionMistakeDTO> questionMistakeDTOList=new ArrayList<>();
            for (QuestionMistake Mistake : mistakeAll){
                if (Mistake.getMistakeStatus()==1){
                    QuestionMistakeDTO questionMistakeDTO=new QuestionMistakeDTO();
                    Long count = questionMistake.countByQuestionIdAndMistakeStatus(Mistake.getQuestionId(), 1);
                    questionMistakeDTO.setCount(count);
                    questionMistakeDTO.setQuestionId(Mistake.getQuestionId());
                    QuestionBank one = questionBankService.findOne(Mistake.getQuestionId());
                    questionMistakeDTO.setCreateTime(one.getCreateTime());
                    questionMistakeDTO.setQuestionContent(one.getQuestionContent());

                    if (!questionMistakeDTOList.contains(questionMistakeDTO)){
                        questionMistakeDTOList.add(questionMistakeDTO);
                        Page<QuestionMistakeDTO> questionMistakeDTOPage=new PageImpl<>(questionMistakeDTOList, PageRequest.of(page - 1, size),size);
                        map.put("questionMistakePage",questionMistakeDTOPage);
                    }
                }
            }
        }catch (Exception e){
            log.info("This Error is ："+ e);
            map.put("msg","数据出错");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("/content/error",map);//跳转到错误页面
        }
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("Mistake/Mistake",map);
    }

}
