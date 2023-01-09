package com.iwfsg.board.global.utils.impl

import com.iwfsg.board.domain.user.presentation.data.presentation.dto.TokenDto
import com.iwfsg.board.global.jwt.JwtTokenProvider
import com.iwfsg.board.global.utils.TokenUtils
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class TokenUtilsImpl(
    private val tokenProvider: JwtTokenProvider
) : TokenUtils {
    override fun getTokenDto(userId: String): TokenDto {
        val accessToken: String = tokenProvider.generateAccessToken(userId)
        val refreshToken: String = tokenProvider.generateRefreshToken(userId)
        val expiredAt: ZonedDateTime = tokenProvider.getExpiredTime()
        return TokenDto(accessToken, refreshToken, expiredAt)
    }
}