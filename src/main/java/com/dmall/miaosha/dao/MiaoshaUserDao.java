package com.dmall.miaosha.dao;

import com.dmall.miaosha.domain.MiaoshaUser;
import com.dmall.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lixianch on 2018/1/26.
 */
@Mapper
public interface MiaoshaUserDao {
    @Select("select * from miaosha_user where id=#{id}")
    public MiaoshaUser getById(@Param("id") Long id);
    @Insert("insert into miaosha_user(nickname,login_name,register_phone,password,salt,head,register_date) values(#{nickname},#{loginName},#{registerPhone}," +
            "#{password},#{salt},#{head},now())")
    public void save(MiaoshaUser user);
}
