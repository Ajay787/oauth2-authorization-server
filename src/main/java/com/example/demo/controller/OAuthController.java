package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class OAuthController {
    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(value = "/oauth/revoke-token", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public void logout(HttpServletRequest request) {
        String inputRefreshToken = request.getHeader("refresh_token");
        if (inputRefreshToken != null) {
//            OAuth2AccessToken accessToken = tokenStore.readAccessToken(request.getParameter("token"));
            
            OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(inputRefreshToken);
            if(null!=refreshToken) {
            	tokenStore.removeAccessTokenUsingRefreshToken(refreshToken);
            	tokenStore.removeRefreshToken(refreshToken);
            }
            
            
        }
    }
}