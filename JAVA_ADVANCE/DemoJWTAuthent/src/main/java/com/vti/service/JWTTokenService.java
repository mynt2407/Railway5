package com.vti.service;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;

public class JWTTokenService {
	private static final long EXPIRATION_TIME = 10800; // 3h
	private static final String SECRET = "12345";
	private static final String PREFIX_TOKEN = "Bearer";
	private static final String AUTHORIZATION = "Authorization";

	//Add token to header
	public static void addJWTTokenToHeader(HttpServletResponse response, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();
		response.addHeader(AUTHORIZATION, PREFIX_TOKEN + " " + JWT);
	}

	//Lay ra token tu header
	public static Authentication parseTokenToUserInformation(HttpServletRequest request) {
		String token = request.getHeader(AUTHORIZATION);
		if (token == null) {
			return null;
		}

		// Parse token to get inform
		String username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(PREFIX_TOKEN, "")).getBody()
				.getSubject();
		return username != null ? new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList())
				: null;
	}
}
