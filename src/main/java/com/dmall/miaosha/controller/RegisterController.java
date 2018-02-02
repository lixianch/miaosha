package com.dmall.miaosha.controller;

import com.dmall.miaosha.common.MsgCode;
import com.dmall.miaosha.common.Result;
import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.service.MiaoshaUserService;
import com.dmall.miaosha.vo.RegisterUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by lixianch on 2018/1/26.
 */
@Controller
@RequestMapping(value = "/regist")
public class RegisterController {
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping(value = "/toRegist")
    public String toRegist(){
        return "register";
    }
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public @ResponseBody Result<String> regist(@Valid RegisterUserVo registerUserVo){
        Result<String> result = null;
        try {
            MiaoshaUser miaoshaUser = new MiaoshaUser();
            BeanUtils.copyProperties(registerUserVo,miaoshaUser);
            miaoshaUserService.save(miaoshaUser);
            result = Result.success();
        } catch (Exception e) {
           result = Result.failed(MsgCode.REG_ERROR.getCode(),MsgCode.REG_ERROR.getMsg());
        }

        return result;
    }
}
