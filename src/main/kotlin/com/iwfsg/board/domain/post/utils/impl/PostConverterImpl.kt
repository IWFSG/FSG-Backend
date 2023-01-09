package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest
import com.iwfsg.board.domain.post.utils.PostConverter
import org.springframework.stereotype.Component

@Component
class PostConverterImpl: PostConverter {
    override fun toDto(request: CreatePostRequest): PostDto {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: PostDto): Post {
        TODO("Not yet implemented")
    }
}