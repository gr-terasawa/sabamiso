/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.framework.core.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.tt.sabamiso.framework.core.userdetails.CustomUser;

/**
 * CustomUserに対応したUserDetailsServiceクラス
 * Spring Securityがデフォルトで提供するRDBMSから主体情報を取得するJdbcDaoImplを拡張している。
 * 
 * @author usr160056
 * @since 2014/01/19
 */
public class CustomUserDetailsService extends JdbcDaoImpl {

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {

        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username }, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                Integer company_id = rs.getInt(4);
                String nickname = rs.getString(5);
                return new CustomUser(username, password, company_id, nickname, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }

        });
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
        UserDetails user = super.createUserDetails(username, userFromUserQuery, combinedAuthorities);

        if (userFromUserQuery instanceof CustomUser) {
            CustomUser customUser = (CustomUser) userFromUserQuery;
            return new CustomUser(user.getUsername(),
                    user.getPassword(),
                    customUser.getCompanyId(),
                    customUser.getNickname(),
                    user.isEnabled(),
                    user.isAccountNonExpired(),
                    user.isCredentialsNonExpired(),
                    user.isAccountNonLocked(),
                    user.getAuthorities());
        } else {
            return user;
        }

    }

}
