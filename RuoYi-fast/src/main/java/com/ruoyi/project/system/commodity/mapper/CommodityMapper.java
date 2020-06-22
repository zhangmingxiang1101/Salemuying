package com.ruoyi.project.system.commodity.mapper;

import java.util.List;

import com.ruoyi.project.system.category.domain.Category;
import com.ruoyi.project.system.commodity.domain.Commodity;

/**
 * 商品管理Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public interface CommodityMapper 
{
    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    public Commodity selectCommodityById(Long id);

    /**
     * 查询商品管理列表
     * 
     * @param commodity 商品管理
     * @return 商品管理集合
     */
    public List<Commodity> selectCommodityList(Commodity commodity);

    /**
     * 新增商品管理
     * 
     * @param commodity 商品管理
     * @return 结果
     */
    public int insertCommodity(Commodity commodity);

    /**
     * 修改商品管理
     * 
     * @param commodity 商品管理
     * @return 结果
     */
    public int updateCommodity(Commodity commodity);

    /**
     * 删除商品管理
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    public int deleteCommodityById(Long id);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityByIds(String[] ids);

    /**
     * 查询商品种类列表
     * @return 商品种类集合
     */
    public List<Category> selectCategory();

    /**
     * 批量入库商品
     * @param ids 需要入库的数据ID
     * @return 结果
     */
    public int procurementCommodityByIds(String[] ids);

    /**
     * 入库商品
     * @param id 需要入库的数据ID
     * @return 结果
     */
    public int procurementCommodityById(Long id);

}
