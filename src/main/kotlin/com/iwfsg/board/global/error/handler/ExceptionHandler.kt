package com.iwfsg.board.global.error.handler

import com.iwfsg.board.global.error.error_code.ErrorCode
import com.iwfsg.board.global.error.exception.BasicException
import com.iwfsg.board.global.error.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BasicException::class)
    fun basicExceptionHandler(error: BasicException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = error.errorCode
        return ResponseEntity(ErrorResponse(errorCode.message,errorCode.status), HttpStatus.valueOf(errorCode.status))
    }
}
