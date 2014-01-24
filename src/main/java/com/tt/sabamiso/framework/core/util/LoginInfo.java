/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.framework.core.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tt.sabamiso.framework.core.userdetails.CustomUser;


/**
 * Login情報の取得を行うユーティリティークラス
 * @author usr160056
 * @since 2014/01/19
 */
public class LoginInfo {

    /**
     * username(ログインID) を返します
     * @return username
     */
    public static String getUsername() {
        return getUser().getUsername();
    }

    /**
     * 会社ID を返します
     * @return companyId
     */
    public static Integer getCompanyId() {
        return getUser().getCompanyId();
    }

    /**
     * ニックネーム を返します
     * @return nickname
     */
    public static String getNickname() {
        return getUser().getNickname();
    }

    /**
     * ThreadLocalが保持するログインユーザを返す
     * @return ログインユーザ情報
     */
    private static CustomUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser user = (CustomUser)authentication.getPrincipal();
        return user;
    }
}
