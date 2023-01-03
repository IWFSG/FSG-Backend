package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class PostQueryConverterImpl: PostQueryConverter {
    override fun toQueryDto(views: Long, entity: Post, likeCount: Long): PostQueryDto = PostQueryDto(
        idx = entity.idx,
        title = entity.title,
        content = entity.content,
        thumbnail = entity.thumbnail,
        views = views,likeCount
    )

    override fun toSummaryQueryResponse(dto: PostQueryDto): PostQueryResponse = PostQueryResponse(
        idx = dto.idx,
        title = dto.title,
        content = dto.content,
        thumbnail = dto.thumbnail,
        views = dto.views,
        likeCount = dto.likeCount
    )

    override fun toPageableResponse(list: List<PostQueryResponse>): PageablePostSummaryQueryResponse = PageablePostSummaryQueryResponse(
        pageablePostList = PageImpl(list)
    )
}