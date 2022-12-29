package com.iwfsg.board.global.security.exception

import com.iwfsg.board.global.error.error_code.ErrorCode
import com.iwfsg.board.global.error.exception.BasicException

class ExpiredJwtException: BasicException(ErrorCode.EXPIRED_TOKEN)