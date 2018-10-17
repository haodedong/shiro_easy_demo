package com.hdd.shiro_demo.controller;

import com.hdd.shiro_demo.domain.UUser;
import com.hdd.shiro_demo.config.MyToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/9 下午 3:15
 */
@RestController
@RequestMapping("ajaxLogin")
public class LoginController {
    @PostMapping(value = "login")
    public Map<String, Object> login(@RequestBody UUser uUser) {
        JdbcRealm jdbc;
        Map<String, Object> map = new HashMap<String, Object>();
        MyToken token = new MyToken();
        token.setUserName(uUser.getNickname());
        token.setPassword(uUser.getPswd());
        try {
            SecurityUtils.getSubject().login(token);
            map.put("status", 200);
            map.put("message", "登录成功");
        } catch (AccountException e) {
            map.put("status", 500);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
