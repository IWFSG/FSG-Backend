package com.iwfsg.board.domain.user.utils

import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.presentation.data.presentation.dto.RegisterDto
import com.iwfsg.board.domain.user.presentation.data.request.RegisterRequest

interface UserConverter {
    fun toDto(request: RegisterRequest): RegisterDto
    fun toEntity(dto: RegisterDto, encodedPassword:String): User

}
