package com.ruoyi.project.system.vip.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 会员对象 sys_vip
 * 
 * @author FSevenT
 * @date 2020-04-08
 */
public class Vip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员ID */
    private Long id;

    /** 会员姓名 */
    private String name;

    /** 会员手机号 */
    private String tel;

    /** 会员余额 */
    private Double balance;

    /** 会员积分 */
    private Double points;

    /** 状态 */
    private String status;

    private String levelName;

    private Double recharge;


    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Double getRecharge() {
        return recharge;
    }

    public void setRecharge(Double recharge) {
        this.recharge = recharge;
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
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setBalance(Double balance) 
    {
        this.balance = balance;
    }

    public Double getBalance() 
    {
        return balance;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("tel", getTel())
            .append("balance", getBalance())
            .append("points", getPoints())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
