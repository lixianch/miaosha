package com.dmall.miaosha.controller;

import com.dmall.miaosha.common.Result;
import com.dmall.miaosha.service.MiaoshaGoodsService;
import com.dmall.miaosha.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lixianch on 2018/2/12.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private MiaoshaGoodsService miaoshaGoodsService;

    @RequestMapping("/listGoods")
    public @ResponseBody Result<List<GoodsVo>> listGoods(){
        List<GoodsVo> goodsVos = miaoshaGoodsService.listGoods();
        Result<List<GoodsVo>> result = Result.success(goodsVos);

        return result;
    }
}
