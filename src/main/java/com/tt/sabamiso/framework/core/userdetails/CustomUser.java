/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.framework.core.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * ニックネームと会社IDを保持する主体情報クラス
 * Spring Securityがデフォルトで提供するUserクラスを拡張している。
 * 
 * @author usr160056
 * @since 2014/01/19
 */
public class CustomUser extends User {

    /** serialVersionUID */
    private static final long serialVersionUID = 6313886327947168665L;

    private final Integer companyId;

    private final String nickname;

    /**
     * コンストラクタ
     * @param username
     * @param password
     * @param company_id
     * @param nickname
     * @param enabled
     * @param accountNonExpired
     * @param credentialsNonExpired
     * @param accountNonLocked
     * @param authorities
     */
    public CustomUser(String username, String password, Integer company_id, String nickname, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.companyId = company_id;
        this.nickname = nickname;
    }

    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }
}
