package org.glue.glue_be.common.jwt;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class UserAuthentication extends UsernamePasswordAuthenticationToken {
	// 사용자 인증 객체 생성
	public UserAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
}
