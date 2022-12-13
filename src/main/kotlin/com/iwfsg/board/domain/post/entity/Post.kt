package com.iwfsg.board.domain.post.entity

import com.iwfsg.board.domain.user.entity.User
import java.time.ZonedDateTime
import javax.persistence.*
import javax.validation.constraints.Size
import kotlin.math.max
import kotlin.math.min

@Entity
class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,

    @Column(nullable = false, length = 2)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @Column(nullable = false)
    val profile: String,

    val createdAT: ZonedDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    val user: User
)