package com.drawhunt.app.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers(HttpMethod.POST, "/user/create").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .anyRequest().authenticated()
            }
            .httpBasic(Customizer.withDefaults())

        return http.build()
    }
}