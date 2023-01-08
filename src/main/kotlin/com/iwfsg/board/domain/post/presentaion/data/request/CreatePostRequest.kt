package com.iwfsg.board.domain.post.presentaion.data.request

data class CreatePostRequest(
    val title: String,
    val content:String,
    val thumbnail: String,
    val category: List<String>
)
