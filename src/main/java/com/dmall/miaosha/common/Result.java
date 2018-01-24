package com.dmall.miaosha.common;

/**
 * Created by lixianch on 2018/1/23.
 */
public class Result<T> {
    public static final String SUCCESS = "0000";
    private String code;
    private String msg;
    private T data;
    public Result(String code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(){
        Result<T> result = success(null);
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<T>(SUCCESS,"成功",data);
        return result;
    }

    public static <T> Result<T> failed(MsgCode msgCode){
        Result<T> result = new Result<T>(msgCode.getCode(),msgCode.getMsg(),null);
        return result;
    }
    public static <T> Result<T> failed(String code,String msg){
        Result<T> result = new Result<T>(code,msg,null);
        return result;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
