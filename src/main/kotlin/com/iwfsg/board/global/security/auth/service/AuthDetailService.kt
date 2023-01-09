package com.iwfsg.board.global.security.auth.service

import com.iwfsg.board.domain.user.domain.exception.UserNotFoundException
import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.global.security.auth.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthDetailService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails =
        userRepository.findUserById(username ?: "")?.let {
            CustomUserDetails(it)
        } ?: throw UserNotFoundException()
}