package com.dmall.miaosha.service;

import com.dmall.miaosha.dao.MiaoshaGoodsDao;
import com.dmall.miaosha.vo.GoodsDetailVo;
import com.dmall.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixianch on 2018/2/11.
 */
@Service
public class MiaoshaGoodsService {
    @Autowired
    private MiaoshaGoodsDao miaoshaGoodsDao;

    public List<GoodsVo> listGoods(){
        return miaoshaGoodsDao.listGoods();
    }
    public GoodsDetailVo listGoodsDetail(Long goodsId){
        return miaoshaGoodsDao.listGoodsDetail(goodsId);
    }
}
