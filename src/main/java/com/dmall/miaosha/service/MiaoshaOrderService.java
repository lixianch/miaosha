package com.dmall.miaosha.service;

import com.dmall.miaosha.dao.MiaoshaOrderDao;
import com.dmall.miaosha.domain.MiaoshaOrder;
import com.dmall.miaosha.domain.OrderInfo;
import com.dmall.miaosha.vo.GoodsVo;
import com.dmall.miaosha.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by lixianch on 2018/2/11.
 */
@Service
public class MiaoshaOrderService {
    @Autowired
    private MiaoshaOrderDao miaoshaOrderDao;

    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(UserVo userVo,GoodsVo goodsVo){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userVo.getId());
        orderInfo.setGoodsId(goodsVo.getId());
        orderInfo.setGoodsName(goodsVo.getGoodsName());
        orderInfo.setGoodsCount(goodsVo.getGoodsCount());
        orderInfo.setGoodsPrice(goodsVo.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setCreateDate(new Date());
        Long orderId = miaoshaOrderDao.insert(orderInfo);

        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setUserId(userVo.getId());
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setGoodsId(goodsVo.getId());
        miaoshaOrderDao.insertMiaoshaOrder(miaoshaOrder);

        return orderId;
    }

    public OrderInfo selectOrderById(Long orderId){
        return miaoshaOrderDao.selectOrderById(orderId);
    }

    public MiaoshaOrder selectMiaoshaOrder(Long userId,Long goodsId){
        return miaoshaOrderDao.selectMiaoshaOrder(userId, goodsId);
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrders(){
        miaoshaOrderDao.deleteOrders();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteMiaoshaOrders(){
        miaoshaOrderDao.deleteMiaoshaOrders();
    }
}
