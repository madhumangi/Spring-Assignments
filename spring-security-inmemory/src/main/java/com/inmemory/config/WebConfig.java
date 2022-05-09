package com.inmemory.config;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
    //do authentication
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        //to do inmemory authentication
        //hard code the username and password
        auth.inMemoryAuthentication()
                .withUser("madhu")
                .password(passwordEncoder().encode("madhu999"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin1234"))
                .roles("ADMIN","USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/products/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin();
    }
    //to encode the password, use BCryptPasswordEncoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //do authorization

}
