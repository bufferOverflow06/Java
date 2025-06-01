package com.example.ProductManagement.utilities;

import org.springframework.security.core.context.SecurityContextHolder;

public class Utility{

    public static final String PUBLIC_ENDPOINTS="/api/public/**";
    public static final String JWT_TOKEN_STRING="JWT";

    public static String getUserFromContext(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

}
