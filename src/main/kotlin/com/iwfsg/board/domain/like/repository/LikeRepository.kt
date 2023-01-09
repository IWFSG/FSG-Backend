package com.iwfsg.board.domain.like.repository

import com.iwfsg.board.domain.like.entity.Like
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository: JpaRepository<Like,Long> {
    fun countByPost(post: Post): Long
    fun existsByUser(user: User): Boolean
}