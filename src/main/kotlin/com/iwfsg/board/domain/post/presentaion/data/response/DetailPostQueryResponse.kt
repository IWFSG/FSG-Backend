package com.iwfsg.board.domain.post.presentaion.data.response

import com.fasterxml.jackson.annotation.JsonFormat
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    val createdAt: ZonedDateTime,
    val commentList: List<Comment>
){
    data class Comment(
        val idx: Long,
        val name: String,
        val content: String,
        val isMine: Boolean
    )
}