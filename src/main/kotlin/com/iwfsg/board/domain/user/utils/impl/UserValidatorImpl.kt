package com.iwfsg.board.domain.user.utils.impl

import com.iwfsg.board.domain.user.domain.exception.UserAlreadyExistException
import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.domain.user.utils.UserUtils
import com.iwfsg.board.domain.user.utils.UserValidator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserValidatorImpl (
    private val userRepository: UserRepository,
    private val userUtils: UserUtils,
    private val passwordEncoder: PasswordEncoder
): UserValidator {
    override fun validateUserId(userId: String) {
        if (userRepository.existsById(userId)) throw UserAlreadyExistException()
    }
}