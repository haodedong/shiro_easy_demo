package com.hdd.shiro_demo.dao;

import com.hdd.shiro_demo.domain.URolePermission;
import com.hdd.shiro_demo.domain.URolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface URolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int countByExample(URolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int deleteByExample(URolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int insert(URolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int insertSelective(URolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    List<URolePermission> selectByExample(URolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") URolePermission record, @Param("example") URolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role_permission
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") URolePermission record, @Param("example") URolePermissionExample example);
}