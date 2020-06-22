package com.ruoyi.project.system.order.mapper;

import java.util.List;
import com.ruoyi.project.system.order.domain.OrderDetail;
import org.aspectj.weaver.ast.Or;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author FSevenT
 * @date 2020-04-20
 */
public interface OrderDetailMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public OrderDetail selectOrderDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param orderDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail);

    /**
     * 新增【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertOrderDetail(OrderDetail orderDetail);

    /**
     * 修改【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateOrderDetail(OrderDetail orderDetail);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderDetailByIds(String[] ids);

    public List<OrderDetail> refundsManage();
}