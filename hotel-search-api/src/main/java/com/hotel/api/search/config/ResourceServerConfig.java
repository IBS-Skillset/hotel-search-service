package com.hotel.api.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ResourceServerConfig {

    @Value("#{systemEnvironment['HOST-AUTH'] ?: 'localhost'}")
    private String authServer;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(
                j -> j.jwt().jwkSetUri("http://"+authServer+":9000/auth-server/oauth2/jwks")
        ).authorizeRequests()
                .anyRequest().authenticated()
                .and().build();
    }

}