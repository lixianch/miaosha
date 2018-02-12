package com.dmall.miaosha.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by lixianch on 2018/2/12.
 */
public class PasswordUtils {
    public static String md5(String pwd,String salt){
        pwd = salt.substring(0,10) + pwd + salt.substring(10);

        return DigestUtils.md5Hex(pwd);
    }
}
