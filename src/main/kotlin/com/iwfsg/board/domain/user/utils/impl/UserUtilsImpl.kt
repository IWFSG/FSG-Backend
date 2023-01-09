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
) : UserUtils {
    override fun findUserById(id: String): User = userRepository.findUserById(id)?:throw UserNotFoundException()
    override fun getCurrentUser(): User {
        val userId: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.findUserById(userId)?:throw UserNotFoundException()
}