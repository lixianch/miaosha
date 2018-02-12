package com.dmall.miaosha.controller;

import com.dmall.miaosha.common.AppException;
import com.dmall.miaosha.common.MsgCode;
import com.dmall.miaosha.common.Result;
import com.dmall.miaosha.service.MiaoshaUserService;
import com.dmall.miaosha.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by lixianch on 2018/2/11.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/doLogin")
    public @ResponseBody Result<String> doLogin(HttpServletResponse response,@RequestBody @Valid UserVo userVo){
        try {
            miaoshaUserService.doLogin(response, userVo);
            return Result.success();
        } catch (AppException e){
            return Result.failed(e.getMsgCode());
        }catch (Exception e) {
            return Result.failed(MsgCode.LOGIN_ERROR);
        }
    }
}
