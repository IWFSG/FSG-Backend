package com.iwfsg.board.domain.user.domain.exception

import com.iwfsg.board.global.error.error_code.ErrorCode
import com.iwfsg.board.global.error.exception.BasicException

class UserNotFoundException: BasicException(ErrorCode.USER_NOT_FOUND) {

}