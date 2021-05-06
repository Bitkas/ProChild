package com.DAI.ProChild.User;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "Admin";
    }
}
