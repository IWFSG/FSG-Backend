package com.iwfsg.board.domain.test_utils

import com.iwfsg.board.domain.user.entity.User

object UserDataUtil {
    private fun id() = listOf("asdfg123","zcvwed123","acfda21").random()
    private fun password() = listOf("password!","TestC0rd!","qwasd@123").random()
    private fun name() = listOf("진시윤","변찬우","김형호").random()
    fun entity() = User(
        id = id(),
        password = password(),
        name = name()
    )
}