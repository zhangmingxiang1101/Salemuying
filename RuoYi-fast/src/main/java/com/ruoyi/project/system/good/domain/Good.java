package com.ruoyi.project.system.good.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品管理对象 sys_good
 * 
 * @author FSevenT
 * @date 2020-04-05
 */
public class Good extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 商品名 */
    @Excel(name = "商品名")
    private String name;

    /** 条码 */
    @Excel(name = "条码")
    private String barCode;

    /** 零售价 */
    @Excel(name = "零售价")
    private Double prices;

    /** 库存 */
    @Excel(name = "库存")
    private Integer stock;

    /** 状态 */
    @Excel(name = "状态")
    private String stauts;

    /** 购买数量 */
    private Integer count;
    /** 备注 */
    private String remarks;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setBarCode(String barCode) 
    {
        this.barCode = barCode;
    }

    public String getBarCode() 
    {
        return barCode;
    }
    public void setPrices(Double prices) 
    {
        this.prices = prices;
    }

    public Double getPrices() 
    {
        return prices;
    }
    public void setStock(Integer stock) 
    {
        this.stock = stock;
    }

    public Integer getStock() 
    {
        return stock;
    }
    public void setStauts(String stauts) 
    {
        this.stauts = stauts;
    }

    public String getStauts() 
    {
        return stauts;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("barCode", getBarCode())
            .append("prices", getPrices())
            .append("stock", getStock())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("stauts", getStauts())
            .append("remarks", getRemarks())
            .toString();
    }
}
