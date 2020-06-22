package com.ruoyi.project.system.refunds.mapper;

import com.ruoyi.project.system.refunds.domain.Refunds;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RefundsMapper {

    /**
     * 查询所有订单记录
     * @return
     */
    public List<Refunds> selectOrderList();

    /**
     * 查询所有订单详细
     * @return
     */
    public List<Refunds> selectOrderDetailList();
}
