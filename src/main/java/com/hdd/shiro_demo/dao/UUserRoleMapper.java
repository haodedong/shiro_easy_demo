package com.hdd.shiro_demo.dao;

import com.hdd.shiro_demo.domain.UUserRole;
import com.hdd.shiro_demo.domain.UUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper

public interface UUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    int countByExample(UUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    int deleteByExample(UUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    @Insert({
        "insert into u_user_role (uid, rid)",
        "values (#{uid,jdbcType=BIGINT}, #{rid,jdbcType=BIGINT})"
    })
    int insert(UUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    int insertSelective(UUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    List<UUserRole> selectByExample(UUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UUserRole record, @Param("example") UUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UUserRole record, @Param("example") UUserRoleExample example);

    List<UUserRole> selectRoleListByUserId(Long id);
}