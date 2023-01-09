package com.iwfsg.board.domain.post.presentaion.data.dto

import java.time.ZonedDateTime

data class PostQueryDto(
    val idx: Long,
    val title: String,
    val content: String,
    val thumbnail: String,
    val views: Long,
    val likeCount: Long,
    val createdAt: ZonedDateTime
)
