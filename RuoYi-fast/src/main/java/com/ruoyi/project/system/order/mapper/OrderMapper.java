package com.ruoyi.project.system.order.mapper;

import java.util.List;
import com.ruoyi.project.system.order.domain.Order;
import com.ruoyi.project.system.order.domain.OrderDetail;

/**
 * 订单管理Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public interface OrderMapper 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理ID
     * @return 订单管理
     */
    public Order selectOrderById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param order 订单管理
     * @return 订单管理集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增订单管理
     * 
     * @param order 订单管理
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改订单管理
     * 
     * @param order 订单管理
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除订单管理
     * 
     * @param id 订单管理ID
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderByIds(String[] ids);

    /**
     * 查询订单详细
     * @param id 订单ID
     * @return 订单详细信息
     */
    public List<OrderDetail> selectDetailById(Long id);
}
