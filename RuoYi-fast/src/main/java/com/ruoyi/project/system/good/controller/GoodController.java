package com.ruoyi.project.system.good.controller;

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
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.service.IGoodService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author FSevenT
 * @date 2020-04-05
 */
@Controller
@RequestMapping("/system/good")
public class GoodController extends BaseController
{
    private String prefix = "system/good";

    @Autowired
    private IGoodService goodService;

    @RequiresPermissions("system:good:view")
    @GetMapping()
    public String good()
    {
        return prefix + "/good";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("system:good:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Good good)
    {
        startPage();
        List<Good> list = goodService.selectGoodList(good);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("system:good:export")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Good good)
    {
        List<Good> list = goodService.selectGoodList(good);
        ExcelUtil<Good> util = new ExcelUtil<Good>(Good.class);
        return util.exportExcel(list, "good");
    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("system:good:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Good good)
    {
        return toAjax(goodService.insertGood(good));
    }

    /**
     * 修改商品管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Good good = goodService.selectGoodById(id);
        mmap.put("good", good);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("system:good:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Good good)
    {
        return toAjax(goodService.updateGood(good));
    }

    /**
     * 下架商品
     */
    @RequiresPermissions("system:good:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(goodService.deleteGoodByIds(ids));
    }
}
