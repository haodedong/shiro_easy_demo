package com.hdd.shiro_demo.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/11 上午 10:13
 */
@Repository("daoSuper")
@Scope("singleton")
public class BaseDaoSuperImpl extends SqlSessionDaoSupport {
    @Resource// SqlSessionFactory是已经注入容器是
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
