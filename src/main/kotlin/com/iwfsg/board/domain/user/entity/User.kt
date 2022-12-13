package com.iwfsg.board.domain.user.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User (
    @Id
    val idx: Long,
)
