package com.dmall.miaosha.common;

/**
 * Created by lixianch on 2018/1/23.
 */
public class MsgCode {
    public static final MsgCode SYS_ERROR = new MsgCode("9999","系统错误，请稍后重试");
    //注册模块
    public static final MsgCode REG_PARAM_EMPTY = new MsgCode("1001","参数为空");
    public static final MsgCode REG_ERROR = new MsgCode("1002","注册失败");
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
