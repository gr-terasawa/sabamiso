package com.tt.sabamiso.integration;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tt.sabamiso.domain.File;
import com.tt.sabamiso.domain.FileExample;
import com.tt.sabamiso.framework.core.integration.Mapper;

public interface FileMapper extends Mapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    int insert(File record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    int insertSelective(File record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    List<File> selectByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    File selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table file
     * @mbggenerated
     */
    int updateByPrimaryKey(File record);
}