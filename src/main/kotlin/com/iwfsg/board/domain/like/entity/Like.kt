package com.iwfsg.board.domain.like.entity

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.global.common.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name="likes")
class Like (
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id", nullable = false)
    val post: Post
) : BaseIdEntity()


