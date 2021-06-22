package com.infinity.co.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/owner","/company","/company/**").hasRole("ADMIN")
                .antMatchers("/companies","/companies/**").hasRole("USER")
                .and().authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/details/**").permitAll()
                .and().csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("guest").password("{noop}guest1234").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin1234").roles("ADMIN");
    }
}
