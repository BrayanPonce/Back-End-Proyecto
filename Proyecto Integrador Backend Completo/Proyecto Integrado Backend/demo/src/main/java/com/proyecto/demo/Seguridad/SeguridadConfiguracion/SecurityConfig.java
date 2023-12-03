package com.proyecto.demo.Seguridad.SeguridadConfiguracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.demo.Seguridad.Filters.JwtAuthenticationFilter;
import com.proyecto.demo.Seguridad.Filters.JwtAuthorizationFilter;
import com.proyecto.demo.Seguridad.JWT.JwtUtils;
import com.proyecto.demo.Seguridad.ServiceSeguridad.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;


    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    JwtAuthorizationFilter jwtAuthorizationFilter;


    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");


        return httpSecurity
        .cors()
        .and()
                            .csrf(
                                config -> config.disable()
                            )
                            .authorizeHttpRequests(
                                auth -> {
                                    auth.requestMatchers("/login").permitAll();
                                    auth.anyRequest().authenticated();
                                }
                            )
                            .sessionManagement(
                                session -> {
                                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                                }
                            )
                            .addFilter(jwtAuthenticationFilter)
                            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                            .build();    




    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



        @Bean
        AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{


            return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                                .userDetailsService(userDetailsServiceImpl)
                                .passwordEncoder(passwordEncoder)
                                .and().build();
        }

     


}
