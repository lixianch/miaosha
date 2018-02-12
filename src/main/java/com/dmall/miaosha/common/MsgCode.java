package com.dmall.miaosha.common;

/**
 * Created by lixianch on 2018/1/23.
 */
public class MsgCode {
    public static final MsgCode SYS_ERROR = new MsgCode("9999","系统错误，请稍后重试");
    //注册模块
    public static final MsgCode REG_PARAM_EMPTY = new MsgCode("1001","参数为空");
    public static final MsgCode REG_ERROR = new MsgCode("1002","注册失败");
    //登录模块
    public static final MsgCode USER_NOT_EXISTS = new MsgCode("2001","用户不存在");
    public static final MsgCode PWD_ERROR = new MsgCode("2002","密码错误");
    public static final MsgCode LOGIN_ERROR = new MsgCode("2999","登录失败，请稍后重试");
    private String code;
    private String msg;
    private MsgCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
