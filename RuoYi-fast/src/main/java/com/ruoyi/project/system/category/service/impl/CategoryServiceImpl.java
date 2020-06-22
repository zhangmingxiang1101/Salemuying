package com.ruoyi.project.system.category.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.category.mapper.CategoryMapper;
import com.ruoyi.project.system.category.domain.Category;
import com.ruoyi.project.system.category.service.ICategoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品种类管理Service业务层处理
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询商品种类管理
     * 
     * @param id 商品种类管理ID
     * @return 商品种类管理
     */
    @Override
    public Category selectCategoryById(Long id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询商品种类管理列表
     * 
     * @param category 商品种类管理
     * @return 商品种类管理
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增商品种类管理
     * 
     * @param category 商品种类管理
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        category.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改商品种类管理
     * 
     * @param category 商品种类管理
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        category.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 删除商品种类管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(String ids)
    {
        return categoryMapper.deleteCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品种类管理信息
     * 
     * @param id 商品种类管理ID
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id)
    {
        return categoryMapper.deleteCategoryById(id);
    }
}
