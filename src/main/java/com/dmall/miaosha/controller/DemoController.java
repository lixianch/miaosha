package com.dmall.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixianch on 2018/1/22.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping("/home")
    public @ResponseBody String home() {
        return "Hello World!";
    }
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","lixianch");
        return "hello";
    }
}
