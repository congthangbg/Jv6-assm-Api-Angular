package com.vn.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component
public class CookieFilter{

//	
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//		      throws IOException, ServletException {
//		    HttpServletRequest request = (HttpServletRequest) req;
//		    Cookie[] cookies = request.getCookies();
//		    Stream<Cookie> stream = java.util.Objects.nonNull(cookies) ? Arrays.stream(cookies) : Stream.empty();
//		    String cookieValue = stream.filter(cookie -> "nameOfMyCookie".equals(cookie.getName()))
//		        .findFirst()
//		        .orElse(new Cookie("nameOfMyCookie", null))
//		        .getValue();
//		    if (Objects.nonNull(cookieValue)) {
////		      request.setAttribute("myCoolObject", myObject);
//		    } 
//		    chain.doFilter(request, res);
//		  }
//	
}
