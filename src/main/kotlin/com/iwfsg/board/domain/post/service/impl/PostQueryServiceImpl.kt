package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.service.PostQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostQueryServiceImpl: PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        TODO("Not yet implemented")
    }
}