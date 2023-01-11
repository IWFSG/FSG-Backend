package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest
import com.iwfsg.board.domain.post.utils.PostConverter
import com.iwfsg.board.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class PostConverterImpl: PostConverter {
    override fun toDto(request: CreatePostRequest): PostDto = PostDto(
        title = request.title,
        content = request.content,
        thumbnail = request.thumbnail,
        category = request.category
    )

    override fun toEntity(dto: PostDto, user: User): Post = Post(
        title = dto.title,
        content = dto.content,
        thumbnail = dto.thumbnail,
        user = user
    )
}