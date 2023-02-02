package com.aster.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	  public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {

			http.authorizeHttpRequests( (auth)->auth
					.requestMatchers("/api/admin").hasAuthority("admin")
					.requestMatchers("/api/secure/user").hasAuthority("user")
					.anyRequest().permitAll()
			).csrf().disable().httpBasic();

			return http.build();
	  }

	
	
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return NoOpPasswordEncoder.getInstance();
	 }

}
