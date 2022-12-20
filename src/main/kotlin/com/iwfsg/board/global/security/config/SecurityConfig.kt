package com.iwfsg.board.global.security.config

import com.iwfsg.board.global.security.filter.JwtAuthenticateFilter
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun security(http: HttpSecurity) : SecurityFilterChain {
        http.csrf().disable()
            .cors().disable()
            .formLogin().disable()
            .authorizeHttpRequests()
            .and()
            .addFilterBefore()
            .addFilterBefore()
            .build()
    }
}