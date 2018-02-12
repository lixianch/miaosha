package com.dmall.miaosha.config;

import com.dmall.miaosha.interceptor.CorsInterceptor;
import com.dmall.miaosha.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lixianch on 2018/2/7.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private CorsInterceptor corsInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
        registry.addInterceptor(loginInterceptor);
    }
}
