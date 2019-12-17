package com.example.demo1.Controller;

import com.example.demo1.Data.QuestionFeedback;
import com.example.demo1.Service.Impl.QuestionFeedbackServiceImpl;
import com.example.demo1.Service.QuestionFeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Admin/FeedBack")
public class QuestionFeedbackController {
    @Autowired
    QuestionFeedbackServiceImpl questionFeedbackService;
    @RequestMapping("/List")
    private ModelAndView List(@RequestParam(value = "page",defaultValue = "1")Integer page,
                              @RequestParam(value = "size",defaultValue = "10")Integer size,
                              Map<String,Object> map){
        try {
            Page<QuestionFeedback> all = questionFeedbackService.findAll(PageRequest.of(page - 1, size));
            map.put("QuestionFeedbackPage",all);
            map.put("currentPage",page);
            map.put("size",size);
        }catch (Exception e){
            log.warn("This Error is ："+ e);
            map.put("msg","数据出错");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("/content/error",map);//跳转到错误页面
        }
        return new ModelAndView("content/Feedback",map);
    }
}
