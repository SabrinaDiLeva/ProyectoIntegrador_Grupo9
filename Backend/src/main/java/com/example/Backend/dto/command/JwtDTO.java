package com.example.Backend.dto.command;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDTO {
    private String token;
    private String bearer;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO() {
    }

    public JwtDTO(String token, String bearer, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.bearer = bearer;
        this.username = username;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
