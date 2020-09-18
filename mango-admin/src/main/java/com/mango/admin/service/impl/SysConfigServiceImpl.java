package com.mango.admin.service.impl;

import com.mango.admin.dao.SysConfigMapper;
import com.mango.admin.entity.SysConfig;
import com.mango.admin.service.SysConfigService;
import com.mango.core.page.MybatisPageHelper;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Override
    public List<SysConfig> findByLable(String lable) {
        return sysConfigMapper.findByLable(lable);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysConfigMapper,"findPage");
    }
}
