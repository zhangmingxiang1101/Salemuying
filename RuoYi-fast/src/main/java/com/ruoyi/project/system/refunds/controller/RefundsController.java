package com.ruoyi.project.system.refunds.controller;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.cashier.domain.Cashier;
import com.ruoyi.project.system.cashier.service.ICashierService;
import com.ruoyi.project.system.good.domain.Good;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.service.IOrderService;
import com.ruoyi.project.system.refunds.domain.Refunds;
import com.ruoyi.project.system.refunds.service.IRefundsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品管理Controller
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/refunds")
public class RefundsController extends BaseController
{
    private String prefix = "system/refunds";

    @Autowired
    private IRefundsService iRefundsService;

    @Autowired
    private IOrderService orderService;


    /**
     * 退货平台跳转
     *
     */
    @GetMapping("")
    public String getIt()
    {
        return prefix + "/refunds";
    }

    /**
     * 订单详细
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        List<OrderDetail> orderDetails = orderService.selectDetailById(id);
        mmap.put("orderDetails", orderDetails);
        return prefix + "/refundsDetail";
    }

    /**
     * 部分退货
     * @param refunds 退货信息
     * @return 服务器通讯状态
     */
    @PostMapping("/refundsSection")
    @ResponseBody
    public AjaxResult refundsSection(Refunds refunds)
    {
        return AjaxResult.success(iRefundsService.refundsSection(refunds));
    }

    /**
     * 整个订单退货
     */
    @RequiresPermissions("system:refunds:remove")
    @Log(title = "全部退货", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        Long id = Long.parseLong(strings[0]);
        return toAjax(iRefundsService.refundsAll(id));
    }



}
