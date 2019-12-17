package com.example.demo1.Controller;

import com.example.demo1.DTO.AnswerDTO;
import com.example.demo1.DTO.QuestionCollectDTO;
import com.example.demo1.Data.QuestionBank;
import com.example.demo1.Data.QuestionCollect;
import com.example.demo1.Service.QuestionBankService;
import com.example.demo1.Service.QuestionCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/Admin/Collect")
public class QuestionCollectController {
    @Autowired
    QuestionCollectService questionCollectService;
    @Autowired
    QuestionBankService questionBankService;
    @RequestMapping("/List")
    private ModelAndView user_collect(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "size",defaultValue = "10")Integer size,
                                      Map<String,Object>map){
        List<QuestionCollect> all = questionCollectService.findAll();
        List<QuestionCollectDTO> questionCollectDTOList= new ArrayList<>();
       try {
           for (QuestionCollect a:all) {
               if (a.getCollectStatus()==1){
                   Long count = questionCollectService.countByQuestionIdAndCollectStatus(a.getQuestionId(), 1);
                   QuestionCollectDTO questionCollectDTO=new QuestionCollectDTO();
                   questionCollectDTO.setQuestionId(a.getQuestionId());
                   QuestionBank bank =questionBankService.findOne(a.getQuestionId());
                   questionCollectDTO.setQuestionContent(bank.getQuestionContent());
                   questionCollectDTO.setCreateTime(bank.getCreateTime());
                   questionCollectDTO.setCount(count);

                   if (!questionCollectDTOList.contains(questionCollectDTO)){
                       questionCollectDTOList.add(questionCollectDTO);
                       Page<QuestionCollectDTO> questionCollectDTOPage=new PageImpl<>(questionCollectDTOList,PageRequest.of(page - 1, size),size);
                       map.put("questionCollect",questionCollectDTOPage);
                   }
               }
           }
       }catch (Exception e){
           log.info("This Error is :",e);
       }
        map.put("currentPage",page);
        map.put("size",size);
       return new ModelAndView("content/Collect",map);
    }
}
