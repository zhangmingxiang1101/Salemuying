package com.ruoyi.project.system.category.mapper;

import java.util.List;
import com.ruoyi.project.system.category.domain.Category;

/**
 * 商品种类管理Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
public interface CategoryMapper 
{
    /**
     * 查询商品种类管理
     * 
     * @param id 商品种类管理ID
     * @return 商品种类管理
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询商品种类管理列表
     * 
     * @param category 商品种类管理
     * @return 商品种类管理集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增商品种类管理
     * 
     * @param category 商品种类管理
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改商品种类管理
     * 
     * @param category 商品种类管理
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 删除商品种类管理
     * 
     * @param id 商品种类管理ID
     * @return 结果
     */
    public int deleteCategoryById(Long id);

    /**
     * 批量删除商品种类管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryByIds(String[] ids);
}
