package com.iwfsg.board.global.jwt

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val userDetailsService: UserDetailsService,
    ) {
    companion object{
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val ACCESS_EXP = 60L * 15 // 15 min
        const val REFRESH_EXP = 60L * 60 * 24 * 7 // 1 weeks
        const val TOKEN_PREFIX = "Bearer "
    }
}
