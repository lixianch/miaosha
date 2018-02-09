package com.dmall.miaosha.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixianch on 2018/2/5.
 */
@Service
public class CorsInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CorsInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        corsHandle(request, response);
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       corsHandle(request, response);
    }

    private void corsHandle(HttpServletRequest request,HttpServletResponse response){
        LOGGER.debug("Begin CorsInterceptor : " + request.getRequestURI());
        String origin = request.getHeader("Origin");

//        if (StringUtils.isNotBlank(origin)) {
            // 允许访问的域
            response.setHeader("Access-Control-Allow-Origin", "*");
            // 允许GET、POST的外域请求
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,HEAD, PUT, PATCH, DELETE, OPTIONS, TRACE");
            // 允许请求带cookie到服务器
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Request-Headers","content-type");
            response.setHeader("Access-Control-Allow-Headers", "Accept-Encoding,User-Agent,Connection,Access-Control-Request-Method,Content-Type, Content-Length, Authorization, Accept, X-Requested-With, Token,Access-Control-Request-Headers");
            response.setHeader("Access-Control-Max-Age", "86400");
            // 设定JSON格式标准输出、及编码
            if(!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
                response.setContentType("application/json; charset=utf-8");
            }
//        }
    }
}
