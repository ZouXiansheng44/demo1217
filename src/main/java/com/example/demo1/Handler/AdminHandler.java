package com.example.demo1.Handler;

import com.example.demo1.Config.ProjectUrlConfig;
import com.example.demo1.Excption.AdminAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class AdminHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = AdminAuthorizeException.class)
    public ModelAndView handerSellerAuthorizeException(){
        return new ModelAndView("redirect:"+ projectUrlConfig.getDomain() +"/Admin/Index");
    }
}
