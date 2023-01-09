package com.iwfsg.board.domain.user.repository

import com.iwfsg.board.domain.user.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken,String> {
}