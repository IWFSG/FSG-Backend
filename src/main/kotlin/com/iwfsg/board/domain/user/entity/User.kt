package com.iwfsg.board.domain.user.entity

import javax.persistence.*

@Entity
class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    @Column(nullable = false)
    val id: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val name: String
)
