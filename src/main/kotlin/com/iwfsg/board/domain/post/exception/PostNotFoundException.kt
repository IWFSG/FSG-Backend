package com.iwfsg.board.domain.post.exception

import com.iwfsg.board.global.error.error_code.ErrorCode
import com.iwfsg.board.global.error.exception.BasicException

class PostNotFoundException: BasicException(ErrorCode.POST_NOT_FOUND)