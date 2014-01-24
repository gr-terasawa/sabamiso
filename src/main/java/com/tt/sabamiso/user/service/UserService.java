/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tt.sabamiso.domain.User;

/**
 * @author usr160056
 * @since 2014/01/15
 */
public interface UserService {

    @Transactional(readOnly = true)
    public User getUser(Integer id);

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void saveUser(User user);

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateUser(User user);

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteUser(Integer id);

    @Transactional(readOnly = true)
    public List<User> getAllUser();

}
