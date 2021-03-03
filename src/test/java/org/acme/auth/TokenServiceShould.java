package org.acme.auth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;

@QuarkusTest
class TokenServiceShould {

	@Inject
	TokenService cut;
	
	@Inject 
	JWTParser parser;
	
	@ConfigProperty(name = "smallrye.jwt.new-token.issuer")
	String issuer;

	
	@Test
	void generateTokenWithForEmptyMap() throws ParseException {
		String token = cut.generateToken(Collections.emptyMap());
		JsonWebToken jwt = parser.parse(token);
		assertThat(jwt.getIssuedAtTime()).isNotNull();
		assertThat(jwt.getExpirationTime()).isNotNull();
		// check configured
		assertThat(jwt.getIssuer()).isEqualTo(issuer);
	}

}
