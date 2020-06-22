package com.ruoyi.project.system.record.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 破损记录对象 sys_damage_record
 * 
 * @author FSevenT
 * @date 2020-04-28
 */
public class DamageRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品名称 */
    private Long commodityId;


    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }



    /** 破损数量 */
    @Excel(name = "破损数量")
    private Integer damageCnt;

    /** 损坏类别 */
    @Excel(name = "损坏类别")
    private String category;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 商品条码 */
    @Excel(name = "条码")
    private String barCode;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamageCnt(Integer damageCnt)
    {
        this.damageCnt = damageCnt;
    }

    public Integer getDamageCnt()
    {
        return damageCnt;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("damageCnt", getDamageCnt())
            .append("category", getCategory())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
