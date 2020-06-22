package com.ruoyi.project.system.commodity.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.category.domain.Category;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.mapper.GoodMapper;
import com.ruoyi.project.system.record.domain.DamageRecord;
import com.ruoyi.project.system.record.mapper.DamageRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.commodity.mapper.CommodityMapper;
import com.ruoyi.project.system.commodity.domain.Commodity;
import com.ruoyi.project.system.commodity.service.ICommodityService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Service
public class CommodityServiceImpl implements ICommodityService 
{
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private DamageRecordMapper damageRecordMapper;

    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    @Override
    public Commodity selectCommodityById(Long id)
    {
        return commodityMapper.selectCommodityById(id);
    }

    /**
     * 查询商品管理列表
     * 
     * @param commodity 商品管理
     * @return 商品管理
     */
    @Override
    public List<Commodity> selectCommodityList(Commodity commodity)
    {
        return commodityMapper.selectCommodityList(commodity);
    }

    /**
     * 新增商品管理
     * 
     * @param commodity 商品管理
     * @return 结果
     */
    @Override
    public int insertCommodity(Commodity commodity)
    {
        commodity.setCreateTime(DateUtils.getNowDate());
        return commodityMapper.insertCommodity(commodity);
    }

    /**
     * 修改商品管理
     * 
     * @param commodity 商品管理
     * @return 结果
     */
    @Override
    public int updateCommodity(Commodity commodity)
    {
        commodity.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        commodity.setUpdateTime(DateUtils.getNowDate());
        return commodityMapper.updateCommodity(commodity);
    }

    /**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityByIds(String ids)
    {
        return commodityMapper.deleteCommodityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    @Override
    public int deleteCommodityById(Long id)
    {
        return commodityMapper.deleteCommodityById(id);
    }

    @Override
    public List<Category> selectCategory() {
        return commodityMapper.selectCategory();
    }

    /**
     * 入库商品管理对象
     *
     * @param id 需要入库的数据ID
     * @return 结果
     */
    @Override
    public int procurementCommodityById(Long id) {
        return commodityMapper.procurementCommodityById(id);
    }

    @Override
        public int procurementSave(Commodity commodity) {
        Commodity commodity1 = commodityMapper.selectCommodityById(commodity.getId());

        Long goodId = goodMapper.selectGoodIdByBarCode(commodity1.getBarCode());
        if(Objects.isNull(goodId)){
            Good goodNew = new Good();
            goodNew.setBarCode(commodity1.getBarCode());
            goodNew.setName(commodity1.getName());
            goodNew.setPrices(commodity.getPrices());
            goodNew.setStock(commodity1.getStock());
            goodNew.setCreateBy(ShiroUtils.getSysUser().getLoginName());
            goodNew.setCreateTime(DateUtils.getNowDate());
            if(goodMapper.insertGood(goodNew) > 0){
                if(commodity.getDamagedCnt() != null && commodity.getDamagedCnt() >= 0){
                    DamageRecord damageRecord = new DamageRecord();
                    damageRecord.setCommodityId(goodNew.getId());
                    damageRecord.setDamageCnt(commodity.getDamagedCnt());
                    damageRecord.setStatus("0");
                    damageRecord.setCategory("0");
                    damageRecord.setCreateBy(ShiroUtils.getSysUser().getLoginName());
                    damageRecord.setCreateTime(DateUtils.getNowDate());
                    damageRecordMapper.insertDamageRecord(damageRecord);
                    commodity1.setStock(commodity1.getStock() - commodity.getDamagedCnt());
                }
                return commodityMapper.procurementCommodityById(commodity.getId());
            }
        }else{
            if(commodity.getDamagedCnt() != null && commodity.getDamagedCnt() >= 0){
                DamageRecord damageRecord = new DamageRecord();
                damageRecord.setCommodityId(goodId);
                damageRecord.setDamageCnt(commodity.getDamagedCnt());
                damageRecord.setStatus("0");
                damageRecord.setCategory("0");
                damageRecord.setCreateBy(ShiroUtils.getSysUser().getLoginName());
                damageRecord.setCreateTime(DateUtils.getNowDate());
                damageRecordMapper.insertDamageRecord(damageRecord);
                commodity1.setStock(commodity1.getStock() - commodity.getDamagedCnt());
            }
            Good good = goodMapper.selectGoodById(goodId);
            good.setStock(good.getStock() + commodity1.getStock());
            good.setPrices(commodity.getPrices());
            good.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
            good.setUpdateTime(DateUtils.getNowDate());
            if(goodMapper.updateGood(good) > 0){

                return commodityMapper.procurementCommodityById(commodity.getId());
            }
        }
        return 0;
    }

    /**
     * 入库商品管理对象
     *
     * @param ids 需要入库的数据ID
     * @return 结果
     */
    @Override
    public int procurementCommodityByIds(String ids) {
        return commodityMapper.procurementCommodityByIds(Convert.toStrArray(ids));
    }
}
