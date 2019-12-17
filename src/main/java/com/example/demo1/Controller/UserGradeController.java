package com.example.demo1.Controller;

import com.example.demo1.Data.UserGrade;
import com.example.demo1.Service.Impl.UserGradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Admin/Grade")
public class UserGradeController {
    @Autowired
    UserGradeServiceImpl userGradeService;
    @RequestMapping("/List")
    private ModelAndView List(@RequestParam(value = "page",defaultValue = "1")Integer page,
                              @RequestParam(value = "size",defaultValue = "10")Integer size,
                              @RequestParam(value = "userId" ,required = false)Integer userId,
                              Map<String,Object> map){
        try {
            if (!StringUtils.isEmpty(userId)){
                Page<UserGrade> byUserId = userGradeService.findByUserId(PageRequest.of(page - 1, size),userId);
                map.put("userPage",byUserId);
                map.put("size",size);
                map.put("currentPage",page);
            }else {
                map.put("msg","用户成绩数据为空!!!");
                map.put("url","/Admin/User/List");
                return new ModelAndView("content/error",map);
            }
        }catch (Exception e){
            map.put("msg","数据查找失败!!!");
            map.put("url","/Admin/User/List");
            return new ModelAndView("content/error",map);
        }
    return new ModelAndView("User/Grade",map);
    }
}
