package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.example.demo.model.UsuarioModel;

@Configuration
@ComponentScan(basePackageClasses = { SecurityConfiguration.class })
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioModel userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider
				= new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	public CookieCsrfTokenRepository csrfTokenRepository() {
		CookieCsrfTokenRepository csrfTokenRepository = new CookieCsrfTokenRepository();
		csrfTokenRepository.setCookieHttpOnly(false);
		return csrfTokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
				.antMatchers("/api/pais/listar").authenticated()
				.antMatchers("/api/pais/salvar").hasAuthority("ADMIN")
				.and().formLogin()
				.and().csrf().disable();
	}

	//	@Override
	//	protected void configure(HttpSecurity http) throws Exception {
	//		// @formatter:off
//		http.csrf().csrfTokenRepository(this.csrfTokenRepository())
//		.and()
//			.authorizeRequests()
//			.antMatchers("/api/public/**")
//			.permitAll();
//
//		http.headers().frameOptions().sameOrigin()
//				.and()
//				.authorizeRequests()
//					.antMatchers("/api/**")
//					.authenticated()
//				.and()
//					.exceptionHandling()
//					.authenticationEntryPoint(new RESTAuthenticationEntryPoint())
//				.and()
//					.oauth2Login()
//					.userInfoEndpoint().oidcUserService(this.userService)
//				.and()
//					.defaultSuccessUrl("/")
//					.failureUrl("/loginerror")
//				.and()
//					.logout()
//					.logoutUrl("/api/logout")
//					.logoutSuccessUrl("/")
//					.clearAuthentication(true)
//					.invalidateHttpSession(true)
//					.deleteCookies("JSESSIONID")
//					;
//		// @formatter:on
	//	}

}
