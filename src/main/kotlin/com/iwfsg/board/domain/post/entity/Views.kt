package com.iwfsg.board.domain.post.entity

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash
class Views (
    @Id
    var postId: Long,
    var viewCount: Long
)