package com.ruoyi.project.system.cashier.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.cashier.domain.Cashier;
import com.ruoyi.project.system.cashier.service.ICashierService;
import com.ruoyi.project.system.category.domain.Category;
import com.ruoyi.project.system.commodity.domain.Commodity;
import com.ruoyi.project.system.commodity.service.ICommodityService;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.good.service.IGoodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 库存管理Controller
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/cashier")
public class CashierController extends BaseController
{
    private String prefix = "system/cashier";

    @Autowired
    private ICashierService iCashierService;



    /**
     * 收银首页跳转
     *
     */
    @GetMapping("")
    public String getIt()
    {
        return prefix + "/getIt";
    }


    /**
     * 查询商品列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Good good)
    {
        startPage();
        List<Good> list = iCashierService.selectGoods(good);
        return getDataTable(list);
    }



    /**
     * 收银台结算
     */
    @PostMapping("/settlement")
    @ResponseBody
    public AjaxResult settlement(@RequestBody Cashier cashier)
    {
        return AjaxResult.success(iCashierService.settlement(cashier));
    }

    @PostMapping("/vipSearch")
    @ResponseBody
    public AjaxResult export(String tel)
    {
        Map<String, Object> stringObjectMap = iCashierService.selectVipByTel(tel);
        System.out.println(tel);
        return AjaxResult.success(stringObjectMap);
    }

    @PostMapping("/salesStatistics")
    @ResponseBody
    public AjaxResult salesStatistics(String param)
    {
        return AjaxResult.success(iCashierService.salesStatistics());
    }
}
