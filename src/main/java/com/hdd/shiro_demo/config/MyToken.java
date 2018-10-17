package com.hdd.shiro_demo.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/9 下午 2:03
 */

public class MyToken implements AuthenticationToken {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 账号
     * @return
     */
    @Override
    public Object getPrincipal() {
        return this.userName;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }
}
