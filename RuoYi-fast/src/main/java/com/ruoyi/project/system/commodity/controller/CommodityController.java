package com.ruoyi.project.system.commodity.controller;

import java.util.List;

import com.ruoyi.project.system.good.domain.Good;
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
import com.ruoyi.project.system.commodity.domain.Commodity;
import com.ruoyi.project.system.commodity.service.ICommodityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/commodity")
public class CommodityController extends BaseController
{
    private String prefix = "system/commodity";

    @Autowired
    private ICommodityService commodityService;

    @RequiresPermissions("system:commodity:view")
    @GetMapping()
    public String commodity(ModelMap map)
    {
        map.put("category",commodityService.selectCategory());
        return prefix + "/commodity";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("system:commodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Commodity commodity)
    {
        startPage();
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("system:commodity:export")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Commodity commodity)
    {
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        ExcelUtil<Commodity> util = new ExcelUtil<Commodity>(Commodity.class);
        return util.exportExcel(list, "commodity");
    }

//    /**
//     * 商品入库
//     */
//    @PostMapping("/procurement")
//    @ResponseBody
//    public AjaxResult procurement(String ids)
//    {
//        return toAjax(commodityService.procurementCommodityByIds(ids));
//    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        map.put("category",commodityService.selectCategory());
        return prefix + "/add";
    }

    /**
     * 入库商品管理
     */
    @GetMapping("/procurement/{id}")
    public String procurement(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("procurementId",id);
        return prefix + "/procurement";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("system:commodity:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Commodity commodity)
    {
        return toAjax(commodityService.insertCommodity(commodity));
    }

    /**
     * 修改商品管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Commodity commodity = commodityService.selectCommodityById(id);
        mmap.put("category",commodityService.selectCategory());
        mmap.put("commodity", commodity);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("system:commodity:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Commodity commodity)
    {
        return toAjax(commodityService.updateCommodity(commodity));
    }


    /**
     * 入库商品
     */
    @RequiresPermissions("system:commodity:procurementSave")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/procurementSave")
    @ResponseBody
    public AjaxResult procurementSave(Commodity commodity)
    {

        return toAjax(commodityService.procurementSave(commodity));
    }

    /**
     * 删除商品管理
     */
    @RequiresPermissions("system:commodity:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(commodityService.deleteCommodityByIds(ids));
    }
}
