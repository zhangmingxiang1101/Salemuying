package com.ruoyi.project.system.cashier.mapper;

import com.ruoyi.project.system.good.domain.Good;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

public interface CashierMapper {
    /**
     * 收银台获取商品列表
     * @param good 查询参数
     * @return 商品列表
     */
    public List<Good> selectGoods(Good good);

    /**
     * 通过手机号码查找会员
     * @param tel 会员手机号
     * @return 会员信息
     */
    public Map<String, Object> selectVipByTel(String tel);


    /**
     * 通过会员ID查找会员
     * @param vipId 会员ID
     * @return 会员信息
     */
    public Map<String, Object> selectVipById(Long vipId);

    /**
     * 查询今日客流量
     * @return 客流量
     */
    public Integer selectPassengerFlow();

    /**
     * 查询今日成交单数
     * @return 今日成交单数
     */
    public Integer selectTransactionOrders();

    /**
     * 查询今日成交额
     * @return
     */
    public Double selectTurnover();

    /**
     * 查询今日售出商品数量
     * @return 今日售出商品数量
     */
    public Integer selectGoodsSold();

}
