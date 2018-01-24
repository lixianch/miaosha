package com.dmall.miaosha.service;

import com.dmall.miaosha.dao.UserDao;
import com.dmall.miaosha.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lixianch on 2018/1/23.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User getById(Integer id){
        return userDao.getById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean tx(){
        User user = new User();
//        user.setId(2);
        user.setName("xiaoming");
        userDao.insert(user);
        user = new User();
//        user.setId(1);
        user.setName("lixianch");
        userDao.insert(user);
        return true;
    }
}
