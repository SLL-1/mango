package com.mango.admin.controller;

import com.mango.admin.service.SysConfigService;
import com.mango.admin.entity.SysConfig;
import com.mango.admin.entity.User;
import com.mango.core.page.PageRequest;
import com.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private SysConfigService sysConfigService;
    @RequestMapping("/hello")
    public User hello(User user){
        return  user;
    }
    @GetMapping("findSysConfig")
    public List<SysConfig> findSysConfig(String lable){
        return sysConfigService.findByLable(lable);
    }
    @GetMapping("findSysConfigByPage")
    public PageResult findSysConfigByPage(PageRequest pageRequest){
        return sysConfigService.findPage(pageRequest);
    }
}
