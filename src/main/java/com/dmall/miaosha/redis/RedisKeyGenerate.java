package com.dmall.miaosha.redis;

/**
 * Created by lixianch on 2018/1/26.
 */
public class RedisKeyGenerate {
    public static String userKey(Long id) {
        return "user:" + id;
    }

    public static String token(String token){
        return "token:" + token;
    }
}
