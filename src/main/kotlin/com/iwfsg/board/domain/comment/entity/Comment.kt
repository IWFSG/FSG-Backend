package com.iwfsg.board.domain.comment.entity

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    @Column(nullable = false)
    val content: String,
    val createAT: ZonedDateTime,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY)
    val post: Post

)