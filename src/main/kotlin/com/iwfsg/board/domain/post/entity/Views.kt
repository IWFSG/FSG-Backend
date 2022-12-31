package com.iwfsg.board.domain.post.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash
class Views (
    @Id
    val postId: Long,
    var vieWCount: Long
)