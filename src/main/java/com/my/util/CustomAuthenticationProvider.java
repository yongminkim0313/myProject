package com.my.util;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider {
//public class CustomAuthenticationProvider implements AuthenticationProvider {

//	@Autowired
//	private UserDetailsService userDeSer;

	@SuppressWarnings("unchecked")
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

//        CustomUserDetails user = (CustomUserDetails) userDeSer.loadUserByUsername(username);

		if (!matchPassword(password, "1")) {
			throw new BadCredentialsException(username);
		}
//        if(!matchPassword(password, user.getPassword())) {
//            throw new BadCredentialsException(username);
//        }
// 
//        if(!user.isEnabled()) {
//            throw new BadCredentialsException(username);
//        }

		return new UsernamePasswordAuthenticationToken(username, password);
//        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}

	private boolean matchPassword(String loginPwd, String password) {
		return loginPwd.equals(password);
	}

}
