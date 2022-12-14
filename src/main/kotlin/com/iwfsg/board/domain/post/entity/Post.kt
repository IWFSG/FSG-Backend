package com.iwfsg.board.domain.post.entity

import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.global.common.entity.BaseIdTimeEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
class Post (
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val content: String,
    @Column(nullable = false)
    val thumbnail: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    val user: User
) : BaseIdTimeEntity()