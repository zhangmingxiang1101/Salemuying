package com.ruoyi.project.system.cashier.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.good.domain.Good;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 商品种类管理对象 sys_category
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public class Cashier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 种类ID */
    private Long vipId;

    private List<Good> goodList;

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
}
