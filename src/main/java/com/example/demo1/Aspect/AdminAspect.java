package com.example.demo1.Aspect;

import com.example.demo1.Constant.CookConstant;
import com.example.demo1.Constant.RedisConstant;
import com.example.demo1.Data.Admin;
import com.example.demo1.Excption.AdminAuthorizeException;
import com.example.demo1.Util.CookUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Component
@Aspect
@Slf4j
public class AdminAspect {
        @Autowired
        private StringRedisTemplate redisTemplate;
        @Pointcut("execution(public * com.example.demo1.Controller.*.*(..))"+
                "&& !execution(public * com.example.demo1.Controller.AdminController.*(..))")
        public void verity(){

        }
        @Before(value = "verity()")
        public void doVerity(){
            ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request =attributes.getRequest();
            Cookie cookie= CookUtil.get(request, CookConstant.TOKEN);
            if (cookie ==null){
                log.warn("【登录校验】Cookie中找不到token");
                throw new AdminAuthorizeException();
            }
            String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            if (StringUtils.isEmpty(tokenValue)){
                log.warn("【登录校验】Redis中找不到token");
                throw new  AdminAuthorizeException();
            }
        }
}
