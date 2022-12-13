package com.iwfsg.board.domain.like.entity

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import javax.persistence.*

@Entity
class Like (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    val post: Post


)


