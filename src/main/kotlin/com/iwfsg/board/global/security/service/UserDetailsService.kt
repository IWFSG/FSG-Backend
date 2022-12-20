package com.iwfsg.board.global.security.service

import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): User {
        return userRepository.findById(username).orElseThrow{} // TODO: 2022/12/20 User not found 만들기 //BaseException(BaseResponseCode.USER_NOT_FOUND) }
    }
}