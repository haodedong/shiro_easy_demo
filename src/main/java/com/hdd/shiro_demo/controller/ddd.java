package com.hdd.shiro_demo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/19 下午 3:09
 */
@RestController
public class ddd {
    @RequestMapping("/admin/a")
    public String toAdmin(){
        return  "aaa -- 授权成功";
    }
    @RequestMapping("/login")
    @RequiresRoles(value={"admin"})
    public String todAdmin(){
        return  "登录";
    }
}
