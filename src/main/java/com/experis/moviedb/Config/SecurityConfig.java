package com.experis.moviedb.Config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(cors -> {})
                .authorizeRequests(authorize -> {
                    authorize
                            .antMatchers( "/api-docs/**", "/api/docs/**", "/api/swagger-ui/**").permitAll()
                            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2 -> {
                    oauth2.jwt();
                });
    }
}
