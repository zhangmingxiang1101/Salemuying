package com.ruoyi.project.system.good.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.good.mapper.GoodMapper;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.service.IGoodService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author FSevenT
 * @date 2020-04-05
 */
@Service
public class GoodServiceImpl implements IGoodService 
{
    @Autowired
    private GoodMapper goodMapper;

    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    @Override
    public Good selectGoodById(Long id)
    {
        return goodMapper.selectGoodById(id);
    }

    /**
     * 查询商品管理列表
     * 
     * @param good 商品管理
     * @return 商品管理
     */
    @Override
    public List<Good> selectGoodList(Good good)
    {
        return goodMapper.selectGoodList(good);
    }

    /**
     * 新增商品管理
     * 
     * @param good 商品管理
     * @return 结果
     */
    @Override
    public int insertGood(Good good)
    {
        good.setCreateTime(DateUtils.getNowDate());
        return goodMapper.insertGood(good);
    }

    /**
     * 修改商品管理
     * 
     * @param good 商品管理
     * @return 结果
     */
    @Override
    public int updateGood(Good good)
    {
        good.setUpdateTime(DateUtils.getNowDate());
        return goodMapper.updateGood(good);
    }

    /**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGoodByIds(String ids)
    {
        return goodMapper.deleteGoodByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    @Override
    public int deleteGoodById(Long id)
    {
        return goodMapper.deleteGoodById(id);
    }

    @Override
    public Long selectGoodIdByBarCode(String barCode) {
        return goodMapper.selectGoodIdByBarCode(barCode);
    }

    @Override
    public Good selectGoodByBarCode(String barCode) {
        return goodMapper.selectGoodByBarCode(barCode);
    }
}
