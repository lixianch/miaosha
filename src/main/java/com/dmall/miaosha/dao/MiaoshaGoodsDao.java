package com.dmall.miaosha.dao;

import com.dmall.miaosha.domain.MiaoshaGoods;
import com.dmall.miaosha.vo.GoodsDetailVo;
import com.dmall.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lixianch on 2018/2/11.
 */
@Mapper
public interface MiaoshaGoodsDao {
    @Select("SELECT a.id,b.goods_name,b.goods_img,b.goods_price,a.miaosha_price,a.stock_count,a.start_date,a.end_date from miaosha_goods a INNER JOIN goods b " +
            "ON a.goods_id=b.id")
    public List<GoodsVo> listGoods();

    @Select("SELECT a.id,b.goods_name,b.goods_title,b.goods_img,b.goods_detail,b.goods_price,a.miaosha_price,a.stock_count,a.start_date,a.end_date from miaosha_goods a " +
            "INNER JOIN goods b ON a.goods_id=b.id WHERE a.id=#{id}")
    public GoodsDetailVo listGoodsDetail(@Param("id") Long id);

    @Update("UPDATE miaosha_goods SET stock_count=stock_count - #{stockCount} WHERE id=#{id}")
    public int deductionStock(MiaoshaGoods miaoshaGoods);

    @Update("UPDATE miaosha_goods SET stock_count=#{stockCount} WHERE id=#{id}")
    public int refreshStock(MiaoshaGoods miaoshaGoods);
}
