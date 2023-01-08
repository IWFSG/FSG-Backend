package com.iwfsg.board.domain.user.utils.impl

import com.iwfsg.board.domain.user.domain.exception.UserNotFoundException
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.domain.user.utils.UserUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserUtilsImpl(
    private val userRepository: UserRepository
): UserUtils {
    override fun getCurrentUser(): User {
        val userId = SecurityContextHolder.getContext().authentication.name
        return userRepository.findUserById(userId).orElseThrow{UserNotFoundException()}
    }
}