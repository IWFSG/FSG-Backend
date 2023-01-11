package com.iwfsg.board.domain.post.presentaion.data.dto

data class PostDto (
    val title: String,
    val content:String,
    val thumbnail: String,
    val category: List<String>
)