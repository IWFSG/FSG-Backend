package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.stereotype.Component

@Component
class PostQueryConverterImpl: PostQueryConverter {
    override fun toSummaryQueryResponse(dto: PostQueryDto): PostQueryResponse {
        TODO("Not yet implemented")
    }

    override fun toPageableResponse(list: List<PostQueryResponse>): PageablePostSummaryQueryResponse {
        TODO("Not yet implemented")
    }
}