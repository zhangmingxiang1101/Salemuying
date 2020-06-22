package com.ruoyi.project.system.refundsManage.controller;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.order.domain.OrderDetail;
import com.ruoyi.project.system.order.service.IOrderService;
import com.ruoyi.project.system.refunds.domain.Refunds;
import com.ruoyi.project.system.refunds.service.IRefundsService;
import com.ruoyi.project.system.refundsManage.service.IRefundsManageService;
import com.ruoyi.project.system.vip.domain.Vip;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理Controller
 * 
 * @author FSevenT
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/refundsManage")
public class RefundsManageController extends BaseController
{
    private String prefix = "system/refundsManage";

    @Autowired
    private IRefundsManageService refundsManageService;


    /**
     * 退货管理跳转
     *
     */
    @GetMapping("")
    public String getIt()
    {
        return prefix + "/refundsManage";
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("system:refundsManage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Vip vip)
    {
        startPage();
        List<OrderDetail> list = refundsManageService.refundsManage();
        return getDataTable(list);
    }


}
