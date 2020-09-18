package com.mango.admin.service;

import com.mango.admin.entity.SysConfig;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;

import java.util.List;

public interface SysConfigService {
    List<SysConfig> findByLable(String lable);

    PageResult findPage(PageRequest pageRequest);
}
