package com.brushmyskills.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.requestMatchers()
         .antMatchers("/login", "/oauth/authorize")
         .and()
         .authorizeRequests()
         .anyRequest()
         .authenticated()
         .and()
         /*Currently we are using spring provided login page*/
         .formLogin()
         /*If require our own custom login page*/
		 //.formLogin().loginPage("/customLoginPageUrl");
         //Allowing everybody to use form login
         .permitAll();
	}
	


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	/*
    	 * Currently we are using in memory authentication for this example
    	 * Later we can change this to authenticate against MySql or any other database
    	 */
  
        auth.parentAuthenticationManager(authenticationManager)
                .inMemoryAuthentication()
                .withUser("bms")
                .password("bms")
                .roles("USER");
    }

}
