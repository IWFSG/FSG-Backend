package com.iwfsg.board.global.error.exception

import com.iwfsg.board.global.error.error_code.ErrorCode

open class BasicException(
    val errorCode: ErrorCode
): RuntimeException()