package com.iwfsg.board.domain.user.entity

import java.util.StringJoiner
import javax.persistence.*

@Entity
class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,

    @Column(nullable = false, length = 8)
    val id: String,

    @Column(nullable = false, length = 8)
    val password: String,

    @Column(nullable = false, length = 1)
    val name: String
)
