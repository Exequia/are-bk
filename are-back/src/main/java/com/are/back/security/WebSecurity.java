package com.are.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.are.back.services.implementations.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	
//	  https://www.adictosaltrabajo.com/2019/03/07/securizando-un-api-rest-con-jwt-y-roles/
//	  https://www.adictosaltrabajo.com/2017/09/25/securizar-un-api-rest-utilizando-json-web-tokens/
//	  https://dev.to/keysh/spring-security-with-jwt-3j76
//	  https://blog.softtek.com/es/autenticando-apis-con-spring-y-jwt

	@Autowired
	private UsersService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.AUTH_LOGIN_URL).permitAll()
			.anyRequest().authenticated().and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las
		// passwords
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
