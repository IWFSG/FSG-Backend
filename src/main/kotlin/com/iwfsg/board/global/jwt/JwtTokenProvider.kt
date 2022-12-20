package com.iwfsg.board.global.jwt

import com.iwfsg.board.global.security.service.UserDetailsService
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties
)

