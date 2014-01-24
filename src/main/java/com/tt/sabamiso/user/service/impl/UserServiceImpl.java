/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tt.sabamiso.domain.User;
import com.tt.sabamiso.integration.UserMapper;
import com.tt.sabamiso.user.service.UserService;


/**
 * @author usr160056
 * @since 2014/01/15
 */
@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /** {@inheritDoc} */
    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /** {@inheritDoc} */
    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    /** {@inheritDoc} */
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /** {@inheritDoc} */
    @Override
    public List<User> getAllUser() {
        return userMapper.selectByExample(null);
    }

}
