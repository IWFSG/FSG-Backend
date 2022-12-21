package com.iwfsg.board.domain.post.entity

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash
class Views (
    @Id
    val postId: Long,
    var vieWCount: Long
)