package com.ruoyi.project.system.refundsManage.service.impl;

import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.mapper.OrderDetailMapper;
import com.ruoyi.project.system.refundsManage.service.IRefundsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundsManageServiceImpl implements IRefundsManageService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> refundsManage() {
        return orderDetailMapper.refundsManage();
    }
}
