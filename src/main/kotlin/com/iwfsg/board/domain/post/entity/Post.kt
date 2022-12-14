package com.iwfsg.board.domain.post.entity

import com.iwfsg.board.domain.user.entity.User
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long,
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val content: String,
    @Column(nullable = false)
    val profile: String,
    val createdAT: ZonedDateTime,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    val user: User
)