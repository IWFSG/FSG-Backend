package com.iwfsg.board.domain.user.repository

import com.iwfsg.board.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User,Long> {
    fun findById(username: String): Optional<User>
}