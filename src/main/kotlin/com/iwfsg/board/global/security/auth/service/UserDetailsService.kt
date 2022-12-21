package com.iwfsg.board.global.security.auth.service

import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.global.error.handler.GlobalExceptionHandler
import com.iwfsg.board.global.security.auth.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
@Transactional
class CustomUserDetailsSerivice(private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findById(username) ?: throw UserNotFou()
        return CustomUserDetails(user)
        }
}
