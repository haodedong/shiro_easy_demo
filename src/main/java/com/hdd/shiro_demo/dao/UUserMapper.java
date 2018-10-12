package com.hdd.shiro_demo.dao;

import com.hdd.shiro_demo.domain.UUser;
import com.hdd.shiro_demo.domain.UUserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int countByExample(UUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int deleteByExample(UUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from u_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into u_user (nickname, email, ",
        "pswd, create_time, ",
        "last_login_time, status)",
        "values (#{nickname,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{pswd,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastLoginTime,jdbcType=TIMESTAMP}, #{status,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int insertSelective(UUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    List<UUser> selectByExample(UUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, nickname, email, pswd, create_time, last_login_time, status",
        "from u_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    UUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UUser record, @Param("example") UUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UUser record, @Param("example") UUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbggenerated
     */
    @Update({
        "update u_user",
        "set nickname = #{nickname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "pswd = #{pswd,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UUser record);
}