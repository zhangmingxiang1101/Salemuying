package com.ruoyi.project.system.record.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class ReBack extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 商品名称*/
    private String name;

    /** 折零数量*/
    private Integer count;
    /** 商品规格*/
    private Integer specifications;
    /** 备注*/
    private String remarks;
    /** 新条码 */
    private String barCode;
    /** 售价 */
    private Double prices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Integer specifications) {
        this.specifications = specifications;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ReBack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", specifications=" + specifications +
                ", remarks='" + remarks + '\'' +
                ", barCode='" + barCode + '\'' +
                ", prices=" + prices +
                '}';
    }
}
