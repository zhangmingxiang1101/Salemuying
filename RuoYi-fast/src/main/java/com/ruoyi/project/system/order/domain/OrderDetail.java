package com.ruoyi.project.system.order.domain;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 订单详细 sys_order_detail
 *
 * @author FSevenT
 * @date 2020-04-20
 */
public class OrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单详细ID */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 商品ID */
    private Long commodityId;

    /** 商品ID */
    private String goodName;

    private Double prices;

    /** 商品个数 */
    private Integer numberOf;

    /** 状态（0:存在 2：删除） */
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setCommodityId(Long commodityId)
    {
        this.commodityId = commodityId;
    }

    public Long getCommodityId()
    {
        return commodityId;
    }
    public void setNumberOf(Integer numberOf)
    {
        this.numberOf = numberOf;
    }

    public Integer getNumberOf()
    {
        return numberOf;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("commodityId", getCommodityId())
                .append("goodName", getGoodName())
                .append("prices", getPrices())
                .append("numberOf", getNumberOf())
                .append("status", getStatus())
                .toString();
    }
}