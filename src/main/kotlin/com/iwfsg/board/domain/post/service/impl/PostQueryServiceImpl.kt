package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postViewsRepository: PostViewsRepository,
    private val postQueryConverter: PostQueryConverter
): PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        TODO("Not yet implemented")
    }
}