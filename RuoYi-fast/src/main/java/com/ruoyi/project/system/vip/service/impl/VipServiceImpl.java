package com.ruoyi.project.system.vip.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.vip.mapper.VipMapper;
import com.ruoyi.project.system.vip.domain.Vip;
import com.ruoyi.project.system.vip.service.IVipService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 会员Service业务层处理
 * 
 * @author FSevenT
 * @date 2020-04-08
 */
@Service
public class VipServiceImpl implements IVipService 
{
    @Autowired
    private VipMapper vipMapper;

    /**
     * 查询会员
     * 
     * @param id 会员ID
     * @return 会员
     */
    @Override
    public Vip selectVipById(Long id)
    {
        return vipMapper.selectVipById(id);
    }

    /**
     * 查询会员列表
     * 
     * @param vip 会员
     * @return 会员
     */
    @Override
    public List<Vip> selectVipList(Vip vip)
    {
        return vipMapper.selectVipList(vip);
    }

    /**
     * 新增会员
     * 
     * @param vip 会员
     * @return 结果
     */
    @Override
    public int insertVip(Vip vip)
    {
        vip.setCreateTime(DateUtils.getNowDate());
        return vipMapper.insertVip(vip);
    }

    /**
     * 修改会员
     * 
     * @param vip 会员
     * @return 结果
     */
    @Override
    public int updateVip(Vip vip)
    {
        return vipMapper.updateVip(vip);
    }

    /**
     * 删除会员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVipByIds(String ids)
    {
        return vipMapper.deleteVipByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员信息
     * 
     * @param id 会员ID
     * @return 结果
     */
    @Override
    public int deleteVipById(Long id)
    {
        return vipMapper.deleteVipById(id);
    }

    @Override
    public int unlockVipByIds(String ids) {
        return vipMapper.unlockVipByIds(Convert.toStrArray(ids));
    }

    @Override
    public int unlockVipById(Long id) {
        return vipMapper.unlockVipById(id);
    }


}
