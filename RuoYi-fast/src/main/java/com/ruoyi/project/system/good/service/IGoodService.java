package com.ruoyi.project.system.good.service;

import java.util.List;
import com.ruoyi.project.system.good.domain.Good;

/**
 * 商品管理Service接口
 * 
 * @author FSevenT
 * @date 2020-04-05
 */
public interface IGoodService 
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
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodByIds(String ids);

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    public int deleteGoodById(Long id);


    public Long selectGoodIdByBarCode(String barCode);

    public Good selectGoodByBarCode(String barCode);
}
