package org.acme.auth;

import java.time.Instant;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class TokenService {

	Logger logger = LoggerFactory.getLogger(TokenService.class);
	
	public String generateToken(Map<String, Object> claims) {
		final Instant now = Instant.now();
		return Jwt.claims(claims)
				.issuedAt(now)
				.sign();
	}

}
