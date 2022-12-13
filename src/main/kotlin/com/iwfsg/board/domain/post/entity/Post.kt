package com.iwfsg.board.domain.post.entity

import com.iwfsg.board.domain.user.entity.User
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    val title: String,
    val content: String,
    val profile: String,
    val createdAT: ZonedDateTime,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User
)