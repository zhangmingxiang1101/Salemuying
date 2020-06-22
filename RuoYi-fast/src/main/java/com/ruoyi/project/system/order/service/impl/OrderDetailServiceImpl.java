package com.ruoyi.project.system.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.order.mapper.OrderDetailMapper;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.service.IOrderDetailService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author FSevenT
 * @date 2020-04-20
 */
@Service
public class OrderDetailServiceImpl implements IOrderDetailService
{
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public OrderDetail selectOrderDetailById(Long id)
    {
        return orderDetailMapper.selectOrderDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param orderDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail)
    {
        return orderDetailMapper.selectOrderDetailList(orderDetail);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOrderDetail(OrderDetail orderDetail)
    {
        return orderDetailMapper.insertOrderDetail(orderDetail);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOrderDetail(OrderDetail orderDetail)
    {
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailByIds(String ids)
    {
        return orderDetailMapper.deleteOrderDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailById(Long id)
    {
        return orderDetailMapper.deleteOrderDetailById(id);
    }
}