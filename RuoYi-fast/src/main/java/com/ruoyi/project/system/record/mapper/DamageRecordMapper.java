package com.ruoyi.project.system.record.mapper;

import java.util.List;

import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.record.domain.DamageRecord;

/**
 * 破损记录Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-28
 */
public interface DamageRecordMapper 
{
    /**
     * 查询破损记录
     * 
     * @param id 破损记录ID
     * @return 破损记录
     */
    public DamageRecord selectDamageRecordById(Long id);

    /**
     * 查询破损记录列表
     * 
     * @param damageRecord 破损记录
     * @return 破损记录集合
     */
    public List<DamageRecord> selectDamageRecordList(DamageRecord damageRecord);

    /**
     * 新增破损记录
     * 
     * @param damageRecord 破损记录
     * @return 结果
     */
    public int insertDamageRecord(DamageRecord damageRecord);

    /**
     * 修改破损记录
     * 
     * @param damageRecord 破损记录
     * @return 结果
     */
    public int updateDamageRecord(DamageRecord damageRecord);

    /**
     * 删除破损记录
     * 
     * @param id 破损记录ID
     * @return 结果
     */
    public int deleteDamageRecordById(Long id);

    /**
     * 批量删除破损记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDamageRecordByIds(String[] ids);

    public DamageRecord selectDamageRecordByGoodId(Long goodId);

    public DamageRecord selectDamageRecordByRecId(Long id);
}
