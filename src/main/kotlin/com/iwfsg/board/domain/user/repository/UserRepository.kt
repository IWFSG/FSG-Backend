package com.iwfsg.board.domain.user.repository

import com.iwfsg.board.domain.user.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepository: CrudRepository<User,Long> {
    fun findUserById(userId: String): User?
    fun existsById(userId: String): Boolean
    fun findById(id: String?): User?
}