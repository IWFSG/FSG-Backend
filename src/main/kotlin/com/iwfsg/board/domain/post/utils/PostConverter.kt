package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest
import com.iwfsg.board.domain.user.entity.User

interface PostConverter {
    fun toDto(request: CreatePostRequest): PostDto
    fun toEntity(dto: PostDto, user: User): Post
}