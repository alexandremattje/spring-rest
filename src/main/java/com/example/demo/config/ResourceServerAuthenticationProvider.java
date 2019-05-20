package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Component
public class ResourceServerAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) {
//		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken();
//		return auth;
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

}
