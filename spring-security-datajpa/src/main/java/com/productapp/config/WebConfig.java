package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    //authentication using jpa
    @Autowired
    private UserDetailsService userDetailsService;


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        user ---------> UserDetails
//            IUserService -
//                    UserServiceImpl,IUserRepo
//
//        using the object of the class that implements userDetailsService
//        auth.userDetailsService(userDetailsService);
//
//
//
//    }



    //to do jpa authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        auth.userDetailsService(userDetailsService);
        http
                .csrf().disable()//disable
                .authorizeRequests()
                .antMatchers("/").permitAll() //permit this url
                .and()
                .authorizeRequests()
                .antMatchers("product-api/admin/**")//.anyRequest()
                .authenticated()
                .and()
                .httpBasic()//for basic authentication
                .and()
                .sessionManagement().disable();//disable the session
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
