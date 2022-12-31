package com.iwfsg.board.domain.user.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken (
    @Id
    val id:String,
    @Indexed
    var token:String,
    @TimeToLive
    var timeToLive: Long
)