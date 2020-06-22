package com.ruoyi.project.system.category.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品种类管理对象 sys_category
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public class Category extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 种类ID */
    private Long id;

    /** 种类名称 */
    @Excel(name = "种类名称")
    private String name;

    /** 状态（0：存在 2：删除） */
    @Excel(name = "状态", readConverterExp = "0=：存在,2=：删除")
    private String status;

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
            .append("name", getName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
