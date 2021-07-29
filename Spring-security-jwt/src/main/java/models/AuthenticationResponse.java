package models;

public class AuthenticationResponse {
//Need A Web Token
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	
	
}
