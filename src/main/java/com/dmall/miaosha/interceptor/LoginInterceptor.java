package com.dmall.miaosha.interceptor;

import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.service.MiaoshaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by lixianch on 2018/2/12.
 */
@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return checkLogin(request, response, handler);
    }

    private boolean checkLogin(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Cookie[] cookies = request.getCookies();
        String requestPath = request.getRequestURI();
        if(cookies == null || requestPath.equalsIgnoreCase("/login/doLogin")){
            return true;
        }
        Optional<Cookie> tokenOptional = Stream.of(cookies).filter(cookie -> cookie.getName().equalsIgnoreCase("token")).findAny();
        if(!tokenOptional.isPresent()){
            try {
                response.sendRedirect("http://localhost:3000/login.html");
            } catch (IOException e) {
                LOGGER.error("重定向到登录界面出错",e);
            }
            return false;
        }else {
            Cookie cookie = tokenOptional.get();
            String token = cookie.getValue();
            MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(response, token);
            request.setAttribute("miaoshaUser",miaoshaUser);
        }
        return true;
    }


}
