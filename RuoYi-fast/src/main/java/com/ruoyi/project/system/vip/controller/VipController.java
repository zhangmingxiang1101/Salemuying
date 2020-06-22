package com.ruoyi.project.system.vip.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.vip.domain.Vip;
import com.ruoyi.project.system.vip.service.IVipService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author FSevenT
 * @date 2020-04-08
 */
@Controller
@RequestMapping("/system/vip")
public class VipController extends BaseController
{
    private String prefix = "system/vip";

    @Autowired
    private IVipService vipService;

    @RequiresPermissions("system:vip:view")
    @GetMapping()
    public String vip()
    {
        return prefix + "/vip";
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("system:vip:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Vip vip)
    {
        startPage();
        List<Vip> list = vipService.selectVipList(vip);
        return getDataTable(list);
    }


    /**
     * 新增会员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会员
     */
    @RequiresPermissions("system:vip:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Vip vip)
    {
        return toAjax(vipService.insertVip(vip));
    }

    /**
     * 修改会员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Vip vip = vipService.selectVipById(id);
        mmap.put("vip", vip);
        return prefix + "/edit";
    }

    /**
     * 跳转会员充值
     */
    @GetMapping("/recharge/{id}")
    public String recharge(@PathVariable("id") Long id, ModelMap mmap)
    {
        Vip vip = vipService.selectVipById(id);
        mmap.put("vip", vip);
        return prefix + "/recharge";
    }

    /**
     * 修改保存会员
     */
    @RequiresPermissions("system:vip:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Vip vip)
    {
        return toAjax(vipService.updateVip(vip));
    }



    /**
     * 会员充值
     */
    @RequiresPermissions("system:vip:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PostMapping("/recharge")
    @ResponseBody
    public AjaxResult rechargeSave(Vip vip)
    {
        vip.setBalance(vip.getRecharge()+vip.getBalance());
        return toAjax(vipService.updateVip(vip));
    }



    /**
     * 删除会员
     */
    @RequiresPermissions("system:vip:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vipService.deleteVipByIds(ids));
    }

    @PostMapping( "/unlock")
    @ResponseBody
    public AjaxResult unlock(String ids)
    {
        return toAjax(vipService.unlockVipByIds(ids));
    }
}
