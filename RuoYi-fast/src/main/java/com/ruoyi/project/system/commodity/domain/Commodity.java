package com.ruoyi.project.system.commodity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品管理对象 sys_commodity
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public class Commodity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 商品条码 */
    @Excel(name = "商品条码")
    private String barCode;

    /** 种类ID */
    private Long typeId;

    /** 种类名称 */
    @Excel(name= "种类名称")
    private String typeName;

    /** 商品名 */
    @Excel(name = "商品名")
    private String name;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Double prices;

    /** 商品价格 */
    @Excel(name = "商品库存")
    private Integer stock;

    /** 状态(0：在售, 1:下架, 2:删除) */
    private String status;
    /**采购地址*/
    @Excel(name = "采购地址")
    private String address;
    /**联系电话*/
    @Excel(name = "联系电话")
    private String tel;

    /**破损数量*/
    private Integer damagedCnt;

    public Integer getDamagedCnt() {
        return damagedCnt;
    }

    public void setDamagedCnt(Integer damagedCnt) {
        this.damagedCnt = damagedCnt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBarCode(String barCode) 
    {
        this.barCode = barCode;
    }

    public String getBarCode() 
    {
        return barCode;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrices(Double prices) 
    {
        this.prices = prices;
    }

    public Double getPrices() 
    {
        return prices;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("barCode", getBarCode())
            .append("typeId", getTypeId())
            .append("name", getName())
            .append("prices", getPrices())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
