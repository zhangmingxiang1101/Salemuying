package com.ruoyi.project.system.record.service.impl;

import java.util.List;
import java.util.Objects;

import com.google.common.primitives.Longs;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.mapper.GoodMapper;
import com.ruoyi.project.system.record.domain.ReBack;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.record.mapper.DamageRecordMapper;
import com.ruoyi.project.system.record.domain.DamageRecord;
import com.ruoyi.project.system.record.service.IDamageRecordService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 破损记录Service业务层处理
 * 
 * @author FSevenT
 * @date 2020-04-28
 */
@Service
public class DamageRecordServiceImpl implements IDamageRecordService 
{
    @Autowired
    private DamageRecordMapper damageRecordMapper;

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 查询破损记录
     * 
     * @param id 破损记录ID
     * @return 破损记录
     */
    @Override
    public DamageRecord selectDamageRecordById(Long id)
    {
        return damageRecordMapper.selectDamageRecordById(id);
    }

    /**
     * 查询破损记录列表
     * 
     * @param damageRecord 破损记录
     * @return 破损记录
     */
    @Override
    public List<DamageRecord> selectDamageRecordList(DamageRecord damageRecord)
    {
        return damageRecordMapper.selectDamageRecordList(damageRecord);
    }

    /**
     * 新增破损记录
     * 
     * @param damageRecord 破损记录
     * @return 结果
     */
    @Override
    public int insertDamageRecord(DamageRecord damageRecord)
    {
        DamageRecord damageRecord1 = damageRecordMapper.selectDamageRecordByGoodId(damageRecord.getCommodityId());
        if(Objects.nonNull(damageRecord1.getId()) && Objects.equals(damageRecord.getCategory(),damageRecord1.getCategory())){
            damageRecord1.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
            damageRecord1.setUpdateTime(DateUtils.getNowDate());
            damageRecord1.setDamageCnt(damageRecord.getDamageCnt()+damageRecord1.getDamageCnt());
            return damageRecordMapper.updateDamageRecord(damageRecord1);
        }
        damageRecord.setCreateTime(DateUtils.getNowDate());
        damageRecord.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        return damageRecordMapper.insertDamageRecord(damageRecord);
    }

    /**
     * 修改破损记录
     * 
     * @param damageRecord 破损记录
     * @return 结果
     */
    @Override
    public int updateDamageRecord(DamageRecord damageRecord)
    {
        damageRecord.setUpdateTime(DateUtils.getNowDate());
        return damageRecordMapper.updateDamageRecord(damageRecord);
    }

    /**
     * 删除破损记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDamageRecordByIds(String ids)
    {
        return damageRecordMapper.deleteDamageRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除破损记录信息
     * 
     * @param id 破损记录ID
     * @return 结果
     */
    @Override
    public int deleteDamageRecordById(Long id)
    {
        return damageRecordMapper.deleteDamageRecordById(id);
    }

    @Override
    public DamageRecord selectDamageRecordByRecId(Long id) {
        return damageRecordMapper.selectDamageRecordByRecId(id);
    }

    @Override
    public int goodReBack(ReBack reBack) {
        DamageRecord damageRecord = damageRecordMapper.selectDamageRecordById(reBack.getId());
        if (reBack.getCount() > damageRecord.getDamageCnt()){
            return 0;
        }
        damageRecord.setDamageCnt(damageRecord.getDamageCnt() - reBack.getCount());
        damageRecord.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        damageRecord.setUpdateTime(DateUtils.getNowDate());
        damageRecordMapper.updateDamageRecord(damageRecord);
        Good good = new Good();
        good.setPrices(reBack.getPrices());
        good.setName(reBack.getName()+"（特价）");
        good.setRemarks(reBack.getRemarks());
        good.setStock(reBack.getCount() * reBack.getSpecifications());
        good.setBarCode(reBack.getBarCode());
        good.setCreateBy(ShiroUtils.getSysUser().getLoginName());
        good.setCreateTime(DateUtils.getNowDate());
        return goodMapper.insertGood(good);
    }
}
