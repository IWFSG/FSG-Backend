package com.iwfsg.board.domain.user.utils.impl

import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.presentation.data.presentation.dto.RegisterDto
import com.iwfsg.board.domain.user.presentation.data.request.RegisterRequest
import com.iwfsg.board.domain.user.utils.UserConverter
import org.springframework.stereotype.Component

@Component
class UserConverterImpl: UserConverter {
    override fun toDto(request: RegisterRequest): RegisterDto =
        RegisterDto(request.id, request.password, request.name)

    override fun toEntity(dto: RegisterDto, encodedPassword: String): User =
        User(dto.id, encodedPassword, dto.name)
}
