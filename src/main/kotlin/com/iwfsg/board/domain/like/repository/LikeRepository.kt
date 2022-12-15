package com.iwfsg.board.domain.like.repository

import com.iwfsg.board.domain.like.entity.Like
import org.springframework.data.jpa.repository.JpaRepository
import java.util.LongSummaryStatistics

interface LikeRepository: JpaRepository<Like,Long> {
}