package com.iwfsg.board.domain.comment.entity

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.global.common.entity.baseTimeEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    @Column(nullable = false)
    val content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val post: Post
):baseTimeEntity()