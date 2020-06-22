package com.ruoyi.project.system.vip.mapper;

import java.util.List;

import com.ruoyi.project.system.vip.domain.Vip;

/**
 * 会员Mapper接口
 * 
 * @author FSevenT
 * @date 2020-04-08
 */
public interface VipMapper 
{
    /**
     * 查询会员
     * 
     * @param id 会员ID
     * @return 会员
     */
    public Vip selectVipById(Long id);

    /**
     * 查询会员列表
     * 
     * @param vip 会员
     * @return 会员集合
     */
    public List<Vip> selectVipList(Vip vip);

    /**
     * 新增会员
     * 
     * @param vip 会员
     * @return 结果
     */
    public int insertVip(Vip vip);

    /**
     * 修改会员
     * 
     * @param vip 会员
     * @return 结果
     */
    public int updateVip(Vip vip);

    /**
     * 冻结会员
     *
     * @param id 会员ID
     * @return 结果
     */
    public int deleteVipById(Long id);


    /**
     * 批量冻结会员
     *
     * @param ids 需要冻结的数据ID
     * @return 结果
     */
    public int deleteVipByIds(String[] ids);

    /**
     * 批量解冻会员
     *
     * @param ids 需要解冻的数据ID
     * @return 结果
     */
    public int unlockVipByIds(String[] ids);

    /**
     * 解冻会员
     *
     * @param id 会员ID
     * @return 结果
     */
    public int unlockVipById(Long id);


}
