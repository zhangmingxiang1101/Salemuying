package com.ruoyi.project.system.refunds.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class Refunds extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long orderId;

    private Double amount;

    private Integer numberOf;

    private Long goodId;

    private String goodName;

    private String status;

    private Long vipId;

    private String vipName;


    private List<Refunds> children = new ArrayList<Refunds>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(Integer numberOf) {
        this.numberOf = numberOf;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public List<Refunds> getChildren() {
        return children;
    }

    public void setChildren(List<Refunds> children) {
        this.children = children;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    @Override
    public String toString() {
        return "Refunds{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", numberOf=" + numberOf +
                ", goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", status='" + status + '\'' +
                ", vipId=" + vipId +
                ", children=" + children +
                '}';
    }
}
