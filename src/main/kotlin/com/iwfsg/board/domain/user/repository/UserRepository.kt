package com.iwfsg.board.domain.user.repository

import com.iwfsg.board.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long> {
}