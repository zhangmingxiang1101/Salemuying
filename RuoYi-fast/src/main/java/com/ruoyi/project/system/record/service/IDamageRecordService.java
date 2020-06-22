package com.ruoyi.project.system.record.service;

import java.util.List;
import com.ruoyi.project.system.record.domain.DamageRecord;
import com.ruoyi.project.system.record.domain.ReBack;

/**
 * 破损记录Service接口
 * 
 * @author FSevenT
 * @date 2020-04-28
 */
public interface IDamageRecordService 
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
     * 批量删除破损记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDamageRecordByIds(String ids);

    /**
     * 删除破损记录信息
     * 
     * @param id 破损记录ID
     * @return 结果
     */
    public int deleteDamageRecordById(Long id);

    public DamageRecord selectDamageRecordByRecId(Long id);

    public int goodReBack(ReBack reBack);

}
