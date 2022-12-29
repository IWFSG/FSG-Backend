package com.iwfsg.board.domain.post.presentaion.data.response

data class PostQueryResponse (
    val idx: Long,
    val title: String,
    val content: String,
    val thumbnail: String,
    val views: Long,
    val likeCount: Long
)