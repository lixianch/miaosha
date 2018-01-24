package com.dmall.miaosha.common;

/**
 * Created by lixianch on 2018/1/23.
 */
public class MsgCode {
    public static final MsgCode SYS_ERROR = new MsgCode("9999","系统错误，请稍后重试");
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
