package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse

interface PostQueryConverter {
    fun toSummaryQueryResponse(dto: PostQueryDto): PostQueryResponse
    fun toPageableResponse(list: List<PostQueryResponse>): PageablePostSummaryQueryResponse
}