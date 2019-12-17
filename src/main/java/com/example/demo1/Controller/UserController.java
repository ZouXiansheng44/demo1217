package com.example.demo1.Controller;

import com.example.demo1.Data.User;
import com.example.demo1.Service.Impl.UserServiceImpl;
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
@RequestMapping("/Admin/User")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/List")
    private ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                              @RequestParam(value = "size",defaultValue = "10")Integer size,
                              Map<String,Object> map){
        try {
            Page<User> userPage = userService.findAll(PageRequest.of(page - 1, size));
            map.put("userPage",userPage);
        }catch (Exception e){
            log.warn("This Error is :"+ e);
            map.put("msg","数据错误!!!");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("content/error",map);
        }
        map.put("size",size);
        map.put("currentPage",page);
        return new ModelAndView("User/User",map);
    }

}
