package com.dmall.miaosha.controller;

import com.dmall.miaosha.common.MsgCode;
import com.dmall.miaosha.common.Result;
import com.dmall.miaosha.domain.User;
import com.dmall.miaosha.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lixianch on 2018/1/22.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Resource
    private UserService userService;
    @RequestMapping("/home")
    public @ResponseBody String home() {
        return "Hello World!";
    }
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","lixianch");
        return "hello";
    }
    @RequestMapping("/db/get")
    public @ResponseBody
    Result<User> getById(Integer id){
        Result<User> result = null;
        try {
            User user = userService.getById(id);
            result = Result.success(user);
        } catch (Exception e) {
            result = Result.failed(MsgCode.SYS_ERROR);
        }
        return result;
    }

    @RequestMapping("/db/tx")
    public @ResponseBody Result<String> tx(){
        Result<String> result = null;
        try {
            boolean r = userService.tx();
            if(r){
                result = Result.success();
            }else {
                result = Result.failed(MsgCode.SYS_ERROR);
            }
        } catch (Exception e) {
            result = Result.failed(MsgCode.SYS_ERROR);
        }

        return result;
    }
}
