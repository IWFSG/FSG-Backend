package com.iwfsg.board.domain.user.presentation

import com.iwfsg.board.domain.user.service.UserAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/auth")
class UserController (
) {
    @PostMapping("/signup")
    fun signup(): ResponseEntity<Void>{
        return ResponseEntity.ok().body(null)
    }
}
