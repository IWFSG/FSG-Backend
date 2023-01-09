package com.iwfsg.board.domain.user.repository

import com.iwfsg.board.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User,Long> {
    fun findUserById(userId: String): User?
    fun existsById(userId: String): Boolean
}