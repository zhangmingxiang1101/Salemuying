package com.ruoyi.project.system.cashier.service;

import com.ruoyi.project.system.cashier.domain.Cashier;
import com.ruoyi.project.system.good.domain.Good;

import java.util.List;
import java.util.Map;

public interface ICashierService {

    public List<Good> selectGoods(Good good);

    /**
     * 通过手机号码查找会员
     * @param tel 会员手机号
     * @return 会员信息
     */
    public Map<String, Object> selectVipByTel(String tel);

    /**
     * 收银台结算
     * @param cashier 购物车信息
     * @return 系统提示
     */
    public Map<String, Object> settlement(Cashier cashier);

    /**
     * 销售统计
     */

    public Map<String,Object> salesStatistics();
}
