package com.hdd.shiro_demo.config;

import com.hdd.shiro_demo.dao.UUserMapper;
import com.hdd.shiro_demo.domain.UUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

/**
 * 授权
 *
 * @author bill.hao
 * @create 2018/10/17 下午 3:32
 */
@Configuration
public class AuthorizationRealm extends AuthorizingRealm {
    @Autowired
    private final UUserMapper uUserMapper;

    public AuthorizationRealm(UUserMapper uUserMapper) {
        this.uUserMapper = uUserMapper;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    public boolean supports(AuthenticationToken token) {
        return token instanceof MyToken;
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
