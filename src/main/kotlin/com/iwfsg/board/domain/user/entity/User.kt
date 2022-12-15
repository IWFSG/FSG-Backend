package com.iwfsg.board.domain.user.entity

import com.iwfsg.board.global.common.entity.BaseIdEntity
import javax.persistence.*

@Entity
class User (
    @Column(nullable = false)
    val id: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val name: String
):BaseIdEntity()
