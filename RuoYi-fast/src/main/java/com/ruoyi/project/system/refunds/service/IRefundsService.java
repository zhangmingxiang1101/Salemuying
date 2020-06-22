package com.ruoyi.project.system.refunds.service;

import com.ruoyi.project.system.refunds.domain.Refunds;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRefundsService {

    public List<Refunds> makeTreeTable();

    public int refundsSection(Refunds refunds);

    public int refundsAll(Long id);


}
