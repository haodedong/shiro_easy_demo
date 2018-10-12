package com.hdd.shiro_demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目名称
 *
 * @author bill.hao
 * @create 2018/10/9 下午 4:06
 */
@SpringBootApplication
/*@ComponentScan("com.hdd.shiro_demo.dao")*/
@MapperScan("com.hdd.shiro_demo.dao")
public class ShiroDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(ShiroDemoApplication.class, args);
    }

    /*static void tet(){
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        DruidDataSource druidDataSource=new DruidDataSource();
        bean.setDataSource(druidDataSource);
    }*/
}
