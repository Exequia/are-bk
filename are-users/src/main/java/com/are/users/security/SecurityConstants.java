package com.are.users.security;

public final class SecurityConstants {

	public static final String AUTH_LOGIN_URL = "/authenticate";

	// Spring Security
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer";

	// JWT
	// Signing key for HS512 algorithm
	// You can use the page https://approsto.com/sha-generator/ to generate all
	// kinds of keys
	public static final String JWT_SECRET = "6zvMzmOyREasrj00qp56lgBLP0O+h7IpTOd47as0stX2Ja+E84TjcblExITXISB16dvw0Wr+uhD2CeqxJI8ymQ";

	public static final String ISSUER_INFO = "https://www.are.com/";
//	public static final String SUPER_SECRET_KEY = "1234";
	public static final int TOKEN_EXPIRATION_TIME = 3600000;
//	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

	private SecurityConstants() {
		throw new IllegalStateException("Cannot create instance of static util class");
	}
}
