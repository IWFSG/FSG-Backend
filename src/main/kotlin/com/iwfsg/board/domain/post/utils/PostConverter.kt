package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest

interface PostConverter {
    fun toDto(request: CreatePostRequest): PostDto
}