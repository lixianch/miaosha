package com.dmall.miaosha.dao;

import com.dmall.miaosha.domain.MiaoshaOrder;
import com.dmall.miaosha.domain.OrderInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by lixianch on 2018/2/11.
 */
@Mapper
public interface MiaoshaOrderDao {
    @Insert("INSERT INTO order_info(user_id,goods_id,delivery_addr_id,goods_name,goods_count,goods_price,order_channel,`status`,create_date,pay_date) " +
            "VALUES(#{userId},#{goodsId},#{deliveryAddrId},#{goodsName},#{goodsCount},#{goodsPrice},#{orderChannel},#{status},#{createDate},#{payDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = long.class,before = false,statement = "SELECT LAST_INSERT_ID()")
    public long insert(OrderInfo orderInfo);

    @Insert("INSERT INTO miaosha_order(user_id,order_id,goods_id) VALUES(#{userId},#{orderId},#{goodsId})")
    public long insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);

    @Select("SELECT * FROM order_info WHERE id=#{id}")
    public OrderInfo selectOrderById(@Param("id") Long orderId);

    @Select("SELECT * from miaosha_order WHERE user_id=#{userId} AND goods_id=#{goodsId}")
    public MiaoshaOrder selectMiaoshaOrder(@Param("userId")Long userId,@Param("goodsId")Long goodsId);

    @Delete("DELETE FROM order_info")
    public void deleteOrders();

    @Delete("DELETE FROM miaosha_order")
    public void deleteMiaoshaOrders();
}
