package com.dmall.miaosha.service;

import com.dmall.miaosha.common.AppException;
import com.dmall.miaosha.common.MsgCode;
import com.dmall.miaosha.dao.MiaoshaUserDao;
import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.domain.User;
import com.dmall.miaosha.redis.RedisKeyGenerate;
import com.dmall.miaosha.redis.RedisService;
import com.dmall.miaosha.utils.PasswordUtils;
import com.dmall.miaosha.vo.UserVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by lixianch on 2018/1/26.
 */
@Service
public class MiaoshaUserService {
    public static final String COOKI_NAME_TOKEN = "token";
    public static final Integer COOKIE_TOKEN_AGE = 5 * 60;
    @Autowired
    private MiaoshaUserDao miaoshaUserDao;
    @Autowired
    private RedisService redisService;

    public MiaoshaUser getById(Long id){
        MiaoshaUser miaoshaUser = miaoshaUserDao.getById(id);

        return miaoshaUser;
    }

    public MiaoshaUser getByToken(HttpServletResponse response,String token){
        MiaoshaUser miaoshaUser = redisService.get(RedisKeyGenerate.token(token), MiaoshaUser.class);
        if(miaoshaUser != null){
            addCookie(response,token,miaoshaUser);
        }

        return miaoshaUser;
    }
    public void save(MiaoshaUser user){
        String salt = UUID.randomUUID().toString().replaceAll("-","");
        user.setSalt(salt);
        String pwd = PasswordUtils.md5(user.getPassword(),salt);
        user.setPassword(pwd);
        miaoshaUserDao.save(user);
    }
    public String doLogin(HttpServletResponse response,UserVo userVo){
        MiaoshaUser miaoshaUser = miaoshaUserDao.getByLoginName(userVo.getLoginName());
        if(miaoshaUser == null){
            throw new AppException(MsgCode.USER_NOT_EXISTS);
        }
        String pwd = PasswordUtils.md5(userVo.getPassword(),miaoshaUser.getSalt());
        if(pwd.equals(miaoshaUser.getPassword())){
            String token = UUID.randomUUID().toString().replaceAll("-","");
            addCookie(response,token,miaoshaUser);
            return token;
        }else {
            throw new AppException(MsgCode.PWD_ERROR);
        }
    }

    private void addCookie(HttpServletResponse response, String token,MiaoshaUser miaoshaUser) {
        redisService.set(RedisKeyGenerate.token(token),miaoshaUser,COOKIE_TOKEN_AGE);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN,token);
        cookie.setMaxAge(COOKIE_TOKEN_AGE);
        response.addCookie(cookie);
    }
}
