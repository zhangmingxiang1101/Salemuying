package com.ruoyi.project.system.refunds.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.mapper.GoodMapper;
import com.ruoyi.project.system.order.domain.Order;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.mapper.OrderDetailMapper;
import com.ruoyi.project.system.order.mapper.OrderMapper;
import com.ruoyi.project.system.refunds.domain.Refunds;
import com.ruoyi.project.system.refunds.mapper.RefundsMapper;
import com.ruoyi.project.system.refunds.service.IRefundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RefundsServiceImpl implements IRefundsService {

    @Autowired
    RefundsMapper refundsMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodMapper goodMapper;

    @Override
    public List<Refunds> makeTreeTable() {
        List<Refunds> orderList = refundsMapper.selectOrderList();
        List<Refunds> orderDetailList = refundsMapper.selectOrderDetailList();
        List<Refunds> treeTableData = new ArrayList<Refunds>();
        treeTableData.addAll(orderList);
        treeTableData.addAll(orderDetailList);
        return treeTableData;
    }

    @Override
    public int refundsSection(Refunds refunds) {
        OrderDetail orderDetail = orderDetailMapper.selectOrderDetailById(refunds.getId());
        Order order = orderMapper.selectOrderById(refunds.getOrderId());
        Good good = goodMapper.selectGoodById(orderDetail.getCommodityId());
        Double amount = good.getPrices() * orderDetail.getNumberOf();
        order.setAmount(order.getAmount() - amount);
        order.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        order.setUpdateTime(DateUtils.getNowDate());
        good.setStock(good.getStock() + orderDetail.getNumberOf());
        orderDetail.setStatus("1");
        orderDetail.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        orderDetail.setUpdateTime(DateUtils.getNowDate());
        if(orderDetailMapper.updateOrderDetail(orderDetail) >= 1){
            orderMapper.updateOrder(order);
            goodMapper.updateGood(good);
        }
        return 1;
    }

    @Override
    public int refundsAll(Long id) {
        List<OrderDetail> orderDetails = orderMapper.selectDetailById(id);
        orderMapper.deleteOrderById(id);
        for(OrderDetail orderDetail : orderDetails){
            Good good = goodMapper.selectGoodById(orderDetail.getCommodityId());
            good.setStock(good.getStock() + orderDetail.getNumberOf());
            goodMapper.updateGood(good);
            orderDetail.setStatus("1");
            orderDetail.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
            orderDetail.setUpdateTime(DateUtils.getNowDate());
            orderDetailMapper.updateOrderDetail(orderDetail);
        }
        return 1;
    }
}
