package com.ruoyi.project.system.good.mapper;

import java.util.List;
import com.ruoyi.project.system.good.domain.Good;

/**
 * 商品管理Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-05
 */
public interface GoodMapper 
{
    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    public Good selectGoodById(Long id);

    /**
     * 查询商品管理列表
     * 
     * @param good 商品管理
     * @return 商品管理集合
     */
    public List<Good> selectGoodList(Good good);

    /**
     * 新增商品管理
     * 
     * @param good 商品管理
     * @return 结果
     */
    public int insertGood(Good good);

    /**
     * 修改商品管理
     * 
     * @param good 商品管理
     * @return 结果
     */
    public int updateGood(Good good);

    /**
     * 删除商品管理
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    public int deleteGoodById(Long id);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodByIds(String[] ids);


    public Long selectGoodIdByBarCode(String barCode);

    public Good selectGoodByBarCode(String barCode);
}
