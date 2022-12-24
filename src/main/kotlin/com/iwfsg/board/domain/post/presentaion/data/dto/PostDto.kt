package com.iwfsg.board.domain.post.presentaion.data.dto

data class PostDto(
    val idx: Long,
    val title: String,
    val thumbnail: String,
    val views: Long,
    val likeCount: String
)
