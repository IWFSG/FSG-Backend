package com.iwfsg.board.domain.post.presentaion.data.request

import org.jetbrains.annotations.NotNull

data class CreatePostRequest(
    @field: NotNull
    val title: String,
    @field: NotNull
    val content:String,
    @field: NotNull
    val thumbnail: String,
    @field: NotNull
    val category: List<String>
)
