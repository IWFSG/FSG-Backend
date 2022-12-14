package com.iwfsg.board.domain.like.entity

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
class Like (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    @JoinColumn(name = "post_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    val post: Post


)


