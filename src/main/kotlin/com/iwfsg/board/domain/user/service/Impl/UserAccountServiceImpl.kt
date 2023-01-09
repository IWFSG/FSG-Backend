package com.iwfsg.board.domain.user.service.Impl

import com.iwfsg.board.domain.user.presentation.data.presentation.dto.RegisterDto
import com.iwfsg.board.domain.user.repository.RefreshTokenRepository
import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.domain.user.service.UserAccountService
import com.iwfsg.board.domain.user.utils.UserConverter
import com.iwfsg.board.domain.user.utils.UserUtils
import com.iwfsg.board.domain.user.utils.UserValidator
import com.iwfsg.board.global.jwt.JwtTokenProvider
import com.iwfsg.board.global.utils.TokenUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl (
    private val userRepository: UserRepository,
    private val userConverter: UserConverter,
    private val userValidator: UserValidator,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: JwtTokenProvider,
    private val tokenUtils: TokenUtils,
    private val userUtils: UserUtils,
    private val refreshTokenRepository: RefreshTokenRepository
): UserAccountService{
    override fun register(dto: RegisterDto) {
        userValidator.validateUserId(dto.id)
            .let { userConverter.toEntity(dto, passwordEncoder.encode(dto.password))}
            .let { userRepository.save(it) }
    }
}
