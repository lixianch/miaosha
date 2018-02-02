package com.dmall.miaosha.service;

import com.dmall.miaosha.dao.MiaoshaUserDao;
import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixianch on 2018/1/26.
 */
@Service
public class MiaoshaUserService {
    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    public void save(MiaoshaUser user){
        miaoshaUserDao.save(user);
    }
}
