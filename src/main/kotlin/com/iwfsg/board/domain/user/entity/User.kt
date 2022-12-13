package com.iwfsg.board.domain.user.entity

import java.util.StringJoiner
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User (
    @Id
    val idx: Long,
    val id: String,
    val password: String,
    @Column()
    val name: String
)
