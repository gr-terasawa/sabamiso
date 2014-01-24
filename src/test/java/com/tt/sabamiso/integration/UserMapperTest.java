/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.FileInputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tt.sabamiso.domain.User;
import com.tt.sabamiso.framework.test.AbstractTestCase;

/**
 * UserMapperのテストケース
 * 
 * @author usr160056
 * @since 2014/01/16
 */
public class UserMapperTest extends AbstractTestCase {

    /** テスト対象 **/
    @Autowired
    private UserMapper userMapper;

    @Override
    protected IDataSet getIDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/com/tt/sabamiso/testdata/UserMapperTest.xml"));
    }

    @Test
    public void 全ユーザ取得() throws Exception {
        List<User> userList = userMapper.selectByExample(null);
        assertThat(userList.size(), is(2));
        assertThat(userList.get(0).getUserId(), is(1));
        assertThat(userList.get(0).getUserName(), is("tera1@test.jp"));
        assertThat(userList.get(0).getPassword(), is("aaaa"));
        assertThat(userList.get(0).getCompanyId(), is(1));
        assertThat(userList.get(0).getNickname(), is("寺澤１"));
        assertThat(userList.get(1).getUserId(), is(2));
        assertThat(userList.get(1).getUserName(), is("tera2@test.jp"));
        assertThat(userList.get(1).getPassword(), is("bbbb"));
        assertThat(userList.get(1).getCompanyId(), is(2));
        assertThat(userList.get(1).getNickname(), is("寺澤２"));
    }

    @Test
    public void ユーザIDを指定して取得() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        assertNotNull(user);
        assertThat(user.getUserId(), is(1));
        assertThat(user.getUserName(), is("tera1@test.jp"));
        assertThat(user.getPassword(), is("aaaa"));
        assertThat(user.getCompanyId(), is(1));
        assertThat(user.getNickname(), is("寺澤１"));
    }


}
