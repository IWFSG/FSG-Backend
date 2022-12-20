package com.iwfsg.board.global.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun security(http: HttpSecurity) : SecurityFilterChain {

    }
}