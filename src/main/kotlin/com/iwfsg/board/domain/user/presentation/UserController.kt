package com.iwfsg.board.domain.user.presentation

import com.iwfsg.board.domain.user.presentation.data.request.RegisterRequest
import com.iwfsg.board.domain.user.service.UserAccountService
import com.iwfsg.board.domain.user.utils.UserConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/auth")
class UserController(
    private val userAccountService: UserAccountService,
    private val userConverter: UserConverter
) {
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid registerRequest: RegisterRequest):ResponseEntity<Void> =
        userConverter.toDto(registerRequest)
            .let { userAccountService.register(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}
