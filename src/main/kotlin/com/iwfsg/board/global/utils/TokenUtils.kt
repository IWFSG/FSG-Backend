package com.iwfsg.board.global.utils

import com.iwfsg.board.domain.user.presentation.data.presentation.dto.TokenDto

interface TokenUtils {
    fun getTokenDto(userId: String): TokenDto
}