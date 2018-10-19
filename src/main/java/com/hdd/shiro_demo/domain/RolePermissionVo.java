package com.hdd.shiro_demo.domain;

import java.util.List;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/19 下午 4:21
 */
public class RolePermissionVo {
    private Long rid;
    private List<UPermission> uPermissions;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public List<UPermission> getuPermissions() {
        return uPermissions;
    }

    public void setuPermissions(List<UPermission> uPermissions) {
        this.uPermissions = uPermissions;
    }
}
