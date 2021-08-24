package com.vn.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vn.service.MyUserDetailService;
import com.vn.utils.JwtUtils;
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Autowired
	JwtUtils jwtTokenUtil;
	
	public static final String MY_COOKIE_NAME = "your-cookie-name";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			jwt = authorizationHeader.substring(7);
			username = jwtTokenUtil.extractUsername(jwt);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.myUserDetailService.loadUserByUsername(username);
			if(jwtTokenUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(jwt,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
//		checkCookie(request, response);
		filterChain.doFilter(request, response);
	}
//	 private void checkCookie(HttpServletRequest request, HttpServletResponse servletResponse) {
//	        boolean cookieExists = Arrays.stream(request.getCookies()).anyMatch(cookie -> cookie.getName().equalsIgnoreCase(MY_COOKIE_NAME));
//	        if (!cookieExists) {
//	            String cookieValue = "your-cookie-value";
//	            Cookie newCookie = new Cookie(MY_COOKIE_NAME, cookieValue);
//	            servletResponse.addCookie(newCookie);
//	        }
//	    }
}
