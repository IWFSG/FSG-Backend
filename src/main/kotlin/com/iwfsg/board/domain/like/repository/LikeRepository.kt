package com.iwfsg.board.domain.like.repository

import com.iwfsg.board.domain.like.entity.Like
import com.iwfsg.board.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import java.util.LongSummaryStatistics

interface LikeRepository: JpaRepository<Like,Long> {
    fun countByPost(post: Post): Long
}