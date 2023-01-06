package com.iwfsg.board.domain.post.presentaion.data.response

import java.time.ZonedDateTime

data class DetailPostQueryResponse (
    val idx: Long,
    val authorName: String,
    val title: String,
    val content: String,
    val thumbnail: String,
    val category: List<String>,
    val views: Long,
    val likeCount: Long,
    val isLiked: Boolean,
    val isMine: Boolean,
    val createdAt: ZonedDateTime,
    val CommentList: List<Comment>
){
    data class Comment(
        val idx: Long,
        val name: String,
        val content: String,
        val isMine: Boolean
    )
}