package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import org.springframework.data.domain.Page

interface PostQueryConverter {
    fun toQueryDto(views: Long, entity: Post): PostQueryDto
    fun toSummaryQueryResponse(dto: PostQueryDto): PostQueryResponse
    fun toPageableResponse(list: List<PostQueryResponse>): PageablePostSummaryQueryResponse
}