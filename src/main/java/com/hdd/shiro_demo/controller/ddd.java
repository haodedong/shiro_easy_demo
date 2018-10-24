package com.hdd.shiro_demo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${aa.bbb.c}")
    private String aa;
    @RequestMapping("/admin/a")
     @RequiresRoles(value={"admin","ddd"})
    public String toAdmin(){
        return  "aaa -- 授权成功";
    }


    @RequestMapping("/logina")
   // @RequiresRoles(value={"admin"})
    public String todAdmin(){
        return  "用户未登录 请登录"+aa;
    }

    @RequestMapping("login")
    public String dd(){
        return "请登录";
    }


}
