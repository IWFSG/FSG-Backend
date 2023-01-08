package com.iwfsg.board.domain.post.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash
class Views (
    @Id
    var postId: Long,
    var viewCount: Long
) {
    fun increaseViewCount() {
        viewCount +=1
    }
}