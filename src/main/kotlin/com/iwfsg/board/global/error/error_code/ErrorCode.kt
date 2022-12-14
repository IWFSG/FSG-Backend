package com.iwfsg.board.global.error.error_code

enum class ErrorCode(val message: String, val status: Int) {
    INTERNET_SERVER_ERROR("Internet Server Error",500),
    EXPIRED_TOKEN("ExpiredToken", 401),
    USER_NOT_FOUND("UserIsNotFound",404),
    POST_NOT_FOUND("PostIsNotFound",404),
    INVALID_TOKEN( "Invalid Token",401),
    USER_ALREADY_EXIST("User Already Exist",409),


}