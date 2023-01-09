package com.iwfsg.board.domain.user.presentation.data.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class RegisterRequest (
    @field:NotNull
    val id: String,
    @field:NotNull
    @field:Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&])[A-Za-z[0-9]\$@\$!%*#?&]{8,20}$")
    val password: String,
    @field:NotNull
    val name:String
)