package br.net.mirante.operadores.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.net.mirante.operadores.security.filters.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	/* METODO PARA AUTENTICAO */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
	
	/* METODO PARA AUTORIZACAO DE ACORDO COM O ROLE */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
			.antMatchers("/api/authenticate").permitAll()
			.antMatchers("/api/operadores").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/pessoas").hasAnyRole("GERENTE", "ANALISTA")
			.antMatchers("/api/pessoas/{id}").hasAnyRole("GERENTE, ANALISTA")
			.antMatchers(HttpMethod.POST, "/api/pessoas").hasRole("GERENTE")
			.antMatchers(HttpMethod.POST, "/api/telefones/{id}").hasRole("GERENTE")
			.antMatchers(HttpMethod.PUT, "/api/pessoas").hasRole("GERENTE")
			.antMatchers(HttpMethod.DELETE, "/api/pessoas/{id}").hasRole("GERENTE")
			.antMatchers(HttpMethod.DELETE, "/api/telefones/{id}").hasRole("GERENTE")
			.anyRequest().authenticated()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.cors();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
