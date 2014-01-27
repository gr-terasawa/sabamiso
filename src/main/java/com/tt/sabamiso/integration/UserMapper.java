package com.tt.sabamiso.integration;

import java.util.List;

import com.tt.sabamiso.domain.User;
import com.tt.sabamiso.domain.UserExample;
import com.tt.sabamiso.framework.core.integration.Mapper;

public interface UserMapper extends Mapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table users
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
}