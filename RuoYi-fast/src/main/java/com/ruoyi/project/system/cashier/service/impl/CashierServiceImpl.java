package com.ruoyi.project.system.cashier.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.cashier.domain.Cashier;
import com.ruoyi.project.system.cashier.mapper.CashierMapper;
import com.ruoyi.project.system.cashier.service.ICashierService;
import com.ruoyi.project.system.category.mapper.CategoryMapper;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.mapper.GoodMapper;
import com.ruoyi.project.system.order.domain.Order;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.mapper.OrderDetailMapper;
import com.ruoyi.project.system.order.mapper.OrderMapper;
import com.ruoyi.project.system.vip.domain.Vip;
import com.ruoyi.project.system.vip.mapper.VipMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class CashierServiceImpl implements ICashierService {

    @Autowired
    private CashierMapper cashierMapper;

    @Autowired
    private VipMapper vipMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> selectGoods(Good good) {
        return cashierMapper.selectGoods(good);
    }

    @Override
    public Map<String, Object> selectVipByTel(String tel) {
        return cashierMapper.selectVipByTel(tel);
    }

    @Override
    public Map<String, Object> settlement(Cashier cashier) {
        Map<String, Object> map = new HashedMap();
        List<Good> goodList = cashier.getGoodList();
        if(goodList.isEmpty()){
            map.put("error","购物车中未添加商品，无法结算");
            return map;
        }
        Double totalAmount = Double.valueOf(0);
        for(Good good : goodList){
            totalAmount +=  good.getPrices() * good.getCount();
        }

        Order order = new Order();
        if(Objects.nonNull(cashier.getVipId())){
            Vip vip = vipMapper.selectVipById(cashier.getVipId());
            order.setVipId(cashier.getVipId());
            Map<String, Object> vipMap = cashierMapper.selectVipById(cashier.getVipId());
            if(totalAmount.compareTo(Double.parseDouble(vipMap.get("balance").toString())) > 0){
                map.put("error","余额不足，请充值！");
                return map;
            }
            Double balance = vip.getBalance() - totalAmount;
            vip.setBalance(balance);
            vip.setPoints(vip.getPoints() + totalAmount);
            vipMapper.updateVip(vip);
        }

        order.setAmount(totalAmount);
        order.setCreateTime(DateUtils.getNowDate());
        order.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        order.setStatus("1");
        orderMapper.insertOrder(order);
        if(Objects.nonNull(order.getId())){
            for(Good good : goodList){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setCommodityId(good.getId());
                orderDetail.setNumberOf(good.getCount());
                orderDetail.setCreateBy(ShiroUtils.getSysUser().getLoginName());
                orderDetail.setCreateTime(DateUtils.getNowDate());
                orderDetail.setStatus("0");
                orderDetailMapper.insertOrderDetail(orderDetail);
                Good good1 = goodMapper.selectGoodById(good.getId());
                good1.setStock(good1.getStock() - good.getCount());
                goodMapper.updateGood(good1);
            }
        }
        map.put("order", order);
        map.put("goodList", goodList);
        map.put("success", "结算成功");
        return map;
    }

    @Override
    public Map<String, Object> salesStatistics() {
        Map<String,Object> map = new HashedMap();
        map.put("passengerFlow", cashierMapper.selectPassengerFlow());
        map.put("transactionOrders", cashierMapper.selectTransactionOrders());
        map.put("turnover", cashierMapper.selectTurnover());
        map.put("goodsSold",cashierMapper.selectGoodsSold());
        return map;
    }
}
