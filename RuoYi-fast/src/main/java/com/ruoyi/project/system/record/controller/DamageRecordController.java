package com.ruoyi.project.system.record.controller;

import java.util.List;

import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.service.IGoodService;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.record.domain.ReBack;
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
import com.ruoyi.project.system.record.domain.DamageRecord;
import com.ruoyi.project.system.record.service.IDamageRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 破损记录Controller
 * 
 * @author FSevenT
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/record")
public class DamageRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private IDamageRecordService damageRecordService;

    @Autowired
    private IGoodService goodService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询破损记录列表
     */
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DamageRecord damageRecord)
    {
        startPage();
        List<DamageRecord> list = damageRecordService.selectDamageRecordList(damageRecord);
        return getDataTable(list);
    }

    /**
     * 导出破损记录列表
     */
    @RequiresPermissions("system:record:export")
    @Log(title = "破损记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DamageRecord damageRecord)
    {
        List<DamageRecord> list = damageRecordService.selectDamageRecordList(damageRecord);
        ExcelUtil<DamageRecord> util = new ExcelUtil<DamageRecord>(DamageRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增破损记录
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("goodList",goodService.selectGoodList(new Good()));
        return prefix + "/add";
    }

    /**
     * 新增保存破损记录
     */
    @RequiresPermissions("system:record:add")
    @Log(title = "破损记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DamageRecord damageRecord)
    {
        return toAjax(damageRecordService.insertDamageRecord(damageRecord));
    }

    /**
     * 修改破损记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DamageRecord damageRecord = damageRecordService.selectDamageRecordById(id);
        mmap.put("damageRecord", damageRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存破损记录
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "破损记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DamageRecord damageRecord)
    {
        return toAjax(damageRecordService.updateDamageRecord(damageRecord));
    }

    /**
     * 删除破损记录
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "破损记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(damageRecordService.deleteDamageRecordByIds(ids));
    }

    /**
     * 订单详细
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        DamageRecord damageRecord = damageRecordService.selectDamageRecordByRecId(id);
        mmap.put("damageRecord", damageRecord);
        return prefix + "/detail";
    }

    @PostMapping("/goodReBack")
    @ResponseBody
    public AjaxResult goodReBack(ReBack reBack)
    {
        return toAjax(damageRecordService.goodReBack(reBack));
    }
}
