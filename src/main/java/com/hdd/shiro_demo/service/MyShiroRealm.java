package com.hdd.shiro_demo.service;

import com.hdd.shiro_demo.dao.UUserMapper;
import com.hdd.shiro_demo.domain.UUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/9 下午 1:59
 */
public class MyShiroRealm implements Realm {



    @Autowired
    private final UUserMapper uUserMapper;

    public MyShiroRealm(UUserMapper uUserMapper) {
        this.uUserMapper = uUserMapper;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof MyToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        UUser uUser;
        MyToken token=(MyToken)authcToken;
      /*  UUserExample example=new UUserExample();
        UUserExample.Criteria criteria=example.createCriteria();
        criteria.andNicknameEqualTo(token.getUserName()).andPswdEqualTo(token.getPassword());*/
        List<UUser> uUsers = uUserMapper.selectByNameAndPassword(token.getUserName(),token.getPassword()    );
        if(CollectionUtils.isEmpty(uUsers)){
            throw new AccountException("账号或者密码不正确");
        }else if(uUsers.get(0).getStatus()==0){
            throw new DisabledAccountException("帐号已经禁止登录！");
        }
        else {
            uUser=uUsers.get(0);
            uUser.setLastLoginTime(new Date());
           // uUserMapper.updateByPrimaryKey(uUser);
        }
        return new SimpleAuthenticationInfo(uUser, uUser.getPswd(), uUser.getNickname());
    }
}
