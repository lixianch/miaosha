package com.dmall.miaosha.service;

import com.dmall.miaosha.dao.MiaoshaUserDao;
import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by lixianch on 2018/1/26.
 */
@Service
public class MiaoshaUserService {
    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    public void save(MiaoshaUser user){
        String salt = UUID.randomUUID().toString().replaceAll("-","");
        user.setSalt(salt);
        String pwd = salt.substring(0,10) + user.getPassword() + salt.substring(10);
        user.setPassword(DigestUtils.md5Hex(pwd));
        miaoshaUserDao.save(user);
    }
}
