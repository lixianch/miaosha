package com.dmall.miaosha.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lixianch on 2018/1/24.
 */
@Service
public class RedisService {
    public static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private JedisPool jedisPool;

    public <T> T get(String key,Class<T> cls){
        T obj = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String result = jedis.get(key);
            obj = strToBean(result,cls);
        } catch (Exception e) {
            LOGGER.error("获取redis值出错",e);
        } finally {
            returnPool(jedis);
        }

        return obj;
    }

    public <T> boolean set(String key,T obj){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key,beanToStr(obj));

            return true;
        } catch (Exception e) {
            LOGGER.error("设置redis值出错",e);
        } finally {
            returnPool(jedis);
        }
        return false;
    }

    public <T> boolean set(String key,T obj,Integer expireTime){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key,expireTime,beanToStr(obj));
            return true;
        } catch (Exception e) {
            LOGGER.error("设置redis值出错",e);
        } finally {
            returnPool(jedis);
        }
        return false;
    }

    private <T> T strToBean(String s,Class<T> cls){
        if(StringUtils.isBlank(s) || cls == null){
            return null;
        }else if(cls == int.class || cls == Integer.class){
            return (T)Integer.valueOf(s);
        }else if(cls == long.class || cls == Long.class){
            return (T)Long.valueOf(s);
        }else if(cls == String.class){
            return (T)s;
        }else {
            return JSONObject.parseObject(s,cls);
        }
    }
    private <T> String beanToStr(T v){
        if(v == null){
            return null;
        }else if(int.class == v || Integer.class == v){
            return "" + v;
        }else if(long.class == v || Long.class == v){
            return "" + v;
        }else {
            return JSON.toJSONString(v);
        }
    }

    private void returnPool(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}
