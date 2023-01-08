package com.iwfsg.board.domain.user.utils

import com.iwfsg.board.domain.user.entity.User

interface UserUtils {
    fun getCurrentUser(): User
}