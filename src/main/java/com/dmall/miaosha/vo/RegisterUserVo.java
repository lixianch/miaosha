package com.dmall.miaosha.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by lixianch on 2018/1/31.
 */
public class RegisterUserVo {
    @NotNull(message = "用户名为空")
    private String nickname;
    @NotNull(message = "登录名为空")
    private String loginName;
    @NotNull(message = "注册手机号为空")
    @Pattern(regexp = "^1\\\\d{10}$",message = "注册手机号不合法")
    private String registerPhone;
    @NotNull(message = "密码为空")
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRegisterPhone() {
        return registerPhone;
    }

    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
