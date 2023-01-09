package com.iwfsg.board.domain.user.service

import com.iwfsg.board.domain.user.presentation.data.presentation.dto.RegisterDto

interface UserAccountService {
    fun register(dto: RegisterDto)

}