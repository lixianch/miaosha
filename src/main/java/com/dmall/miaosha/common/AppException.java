package com.dmall.miaosha.common;

/**
 * Created by lixianch on 2018/1/23.
 */
public class AppException extends RuntimeException{
    private MsgCode msgCode;
    public AppException(MsgCode msgCode){
        super(msgCode.getMsg());
        this.msgCode = msgCode;
    }

    public MsgCode getMsgCode() {
        return msgCode;
    }
}
