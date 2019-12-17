package com.example.demo1.Controller;

import com.example.demo1.Config.ProjectUrlConfig;
import com.example.demo1.Constant.CookConstant;
import com.example.demo1.Constant.RedisConstant;
import com.example.demo1.Data.Admin;
import com.example.demo1.Service.Impl.AdminServiceImpl;
import com.example.demo1.Util.CookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    ProjectUrlConfig projectUrlConfig;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    AdminServiceImpl adminService;
    Admin admin;
    @GetMapping("/Index")
    private ModelAndView Index(){
        return new ModelAndView("Admin/Login");
    }
    @GetMapping("/Login")
    private ModelAndView Login(@RequestParam(value = "adminName",required = false) String adminName,
                               @RequestParam(value = "adminPassword",required = false) String adminPassword,
                               HttpServletResponse response,
                               Map<String,Object>map){
        try {
            if (!StringUtils.isEmpty(adminName) && !StringUtils.isEmpty(adminPassword)){
                admin = adminService.findByAdminNameAndAdminPassword(adminName,adminPassword);
            }
            if (admin == null){
                map.put("msg","账户密码错误");
                map.put("url","/Admin/Index");
                return new ModelAndView("/content/error",map);//跳转到错误页面
            }
            String token = UUID.randomUUID().toString();
            Integer expire = RedisConstant.EXPIRE;
            redisTemplate.opsForValue().set(
                    String.format(RedisConstant.TOKEN_PREFIX,token),
                    admin.getAdminName(),
                    expire,
                    TimeUnit.SECONDS
            );
            CookUtil.set(response, CookConstant.TOKEN,token,expire);
            return new ModelAndView("redirect:"+ projectUrlConfig.getDomain() +"/Admin/Question/List");//跳转到Admin管理页面
        }catch (Exception e){
            map.put("msg","账户密码错误");
            map.put("url","/Admin/Index");
            return new ModelAndView("/content/error",map);//跳转到错误页面
        }
    }
    @GetMapping("/LoginOut")
    private ModelAndView LoginOut(HttpServletResponse response,
                                  HttpServletRequest request,
                                  Map<String,Object>map){
        try {
            Cookie cookie=CookUtil.get(request,CookConstant.TOKEN);
            if (cookie!=null){
                redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
                CookUtil.set(response,CookConstant.TOKEN,null,0);
            }
            map.put("msg","注销成功");
            map.put("url","/Admin/Index");
        }catch (Exception e){
            map.put("msg","注销失败");
            map.put("url","/Admin/Question/List");
            return new ModelAndView("/content/error",map);
        }
        return new ModelAndView("/content/success",map);
    }

}
