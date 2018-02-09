package com.dmall.miaosha.controller;

import com.dmall.miaosha.common.MsgCode;
import com.dmall.miaosha.common.Result;
import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.service.MiaoshaUserService;
import com.dmall.miaosha.vo.RegisterUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lixianch on 2018/1/26.
 */
@Controller
@RequestMapping(value = "/regist")
public class RegisterController {
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public @ResponseBody Result<String> regist(@RequestBody @Valid RegisterUserVo registerUserVo,BindingResult bindingResult){
        Result<String> result = null;
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for(ObjectError error : errorList){
                sb.append(error.getDefaultMessage()).append("<br/>");
            }
            result = Result.failed(MsgCode.REG_PARAM_EMPTY.getCode(),sb.toString());
            return result;
        }
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
