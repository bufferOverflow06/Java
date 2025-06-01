package com.example.ProductManagement.model;

import org.springframework.security.core.GrantedAuthority;

public class RoleGrantedAuthority implements GrantedAuthority{
    String roles;

    public RoleGrantedAuthority(){

    }

    public RoleGrantedAuthority(String roles) {
        this.roles = roles;
    }

    @Override
    public String getAuthority() {
        return this.roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "RoleGrantedAuthority [roles=" + roles + "]";
    }
}
