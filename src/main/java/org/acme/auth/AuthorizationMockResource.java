package org.acme.auth;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authorize")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorizationMockResource {

	@Inject
	TokenService tokenService;

	@POST
	public TokenResource echo(Map<String, Object> claims) {
		return new TokenResource(tokenService.generateToken(claims));
	}

}
