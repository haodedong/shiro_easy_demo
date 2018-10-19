package com.hdd.shiro_demo.config;

import com.hdd.shiro_demo.dao.URoleMapper;
import com.hdd.shiro_demo.dao.URolePermissionMapper;
import com.hdd.shiro_demo.dao.UUserMapper;
import com.hdd.shiro_demo.dao.UUserRoleMapper;
import com.hdd.shiro_demo.domain.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 授权
 *
 * @author bill.hao
 * @create 2018/10/17 下午 3:32
 */
@Configuration
public class AuthorizationRealm extends AuthorizingRealm {
    private final UUserMapper uUserMapper;

    private final UUserRoleMapper uUserRoleMapper;

    private final URolePermissionMapper uRolePermissionMapper;

    private final URoleMapper uRoleMapper;
/*    public AuthorizationRealm(){

    }*/
    public AuthorizationRealm(URoleMapper uRoleMapper,
                              URolePermissionMapper uRolePermissionMapper,
                              UUserRoleMapper uUserRoleMapper,
                              UUserMapper uUserMapper) {
        this.uUserMapper = uUserMapper;
        this.uUserRoleMapper=uUserRoleMapper;
        this.uRolePermissionMapper=uRolePermissionMapper;
        this.uRoleMapper=uRoleMapper;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UUser userName = (UUser)principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        UUser user = uUserMapper.selectByName(userName.getNickname());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<UUserRole> uUserRoles = uUserRoleMapper.selectRoleListByUserId(user.getId());
        Set<String> urls=new HashSet<>();
        List<URole> uRoles=new ArrayList<>();
        uUserRoles.forEach(item->{
            URole uRole = uRoleMapper.selectByPrimaryKey(item.getRid());
            RolePermissionVo rolePermissionVo = uRolePermissionMapper.selectPermissioinByRoleId(item.getRid());
            Set<String> urlList = rolePermissionVo.getuPermissions().stream().map(UPermission::getUrl).collect(Collectors.toSet());
            if(CollectionUtils.isNotEmpty(urlList)){
                urls.addAll(urlList);
            }
            uRoles.add(uRole);
        });
        simpleAuthorizationInfo.addRoles(uRoles.stream().map(URole::getName).collect(Collectors.toList()));
        simpleAuthorizationInfo.setStringPermissions(urls);
       /* if(CollectionUtils.isNotEmpty(uUserRoles)){
            uUserRoles.forEach(item->{

            });
        }*/
        return simpleAuthorizationInfo;
    }
    public boolean supports(AuthenticationToken token) {
     return token instanceof MyToken;
//        return null;
   }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String  password= (String)authcToken.getCredentials();
        String useaName = (String)authcToken.getPrincipal();
        UUser uUser;
       /* System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        MyToken token = (MyToken) authcToken;*/
      /*  UUserExample example=new UUserExample();
        UUserExample.Criteria criteria=example.createCriteria();
        criteria.andNicknameEqualTo(token.getUserName()).andPswdEqualTo(token.getPassword());*/
            List<UUser> uUsers = uUserMapper.selectByNameAndPassword(useaName, password);
        if (CollectionUtils.isEmpty(uUsers)) {
            throw new AccountException("账号或者密码不正确");
        } else if (uUsers.get(0).getStatus() == 0) {
            throw new DisabledAccountException("帐号已经禁止登录！");
        } else {
            uUser = uUsers.get(0);
            uUser.setLastLoginTime(new Date());
            uUserMapper.updateByPrimaryKey(uUser);
        }
        return new SimpleAuthenticationInfo(uUser, uUser.getPswd(), uUser.getNickname());
    }
}
