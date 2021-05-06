package com.DAI.ProChild.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import java.util.ArrayList;
import java.util.List;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    public CustomAuthenticationProvider() {
        //this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        String password = credentials.toString();

        UserDetails user = this.myUserDetailsService.loadUserByUsername(name);

        if(this.checkCredentials(name, credentials, user)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(user.getAuthorities().stream().findFirst().get());

            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);

            return auth;
        } else {
            throw new BadCredentialsException("Authentication failed for user: " + name);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean checkCredentials(String name, Object credentials, UserDetails user) {
        if(!(user.getUsername().equals(name) && user.getPassword().equals(credentials))) {
            return false;
        } else {
            return true;
        }
    }
}
