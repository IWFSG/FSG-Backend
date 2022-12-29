package com.iwfsg.board.global.security.exception

import com.iwfsg.board.global.error.error_code.ErrorCode
import com.iwfsg.board.global.error.exception.BasicException

class InvalidTokenException: BasicException(ErrorCode.INVALID_TOKEN)