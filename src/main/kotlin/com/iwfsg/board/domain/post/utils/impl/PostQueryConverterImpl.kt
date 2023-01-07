package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.DetailPostQueryResponse
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

    override fun toDetailQueryDto(
        dto: PostQueryDto,
        liked: Boolean,
        mined: Boolean,
        comment: List<Comment>,
        category: List<String>,
        userName: String,
    ): DetailPostQueryDto {
        TODO("Not yet implemented")
    }

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

    override fun toQueryResponse(dto: DetailPostQueryDto): DetailPostQueryResponse = DetailPostQueryResponse(
        idx = dto.idx,
        authorName = dto.authorName,
        title = dto.title,
        content = dto.content,
        thumbnail = dto.thumbnail,
        category = dto.category,
        views = dto.views,
        likeCount = dto.likeCount,
        isLiked = dto.isLiked,
        isMine = dto.isMine,
        createdAt = dto.createdAt,
        commentList = toCommentListResponse(dto.CommentList)
    )
    private fun toCommentListResponse(dto: List<DetailPostQueryDto.Comment>): List<DetailPostQueryResponse.Comment> =
        dto.map { DetailPostQueryResponse.Comment(
            idx = it.idx,
            name = it.name,
            content = it.content,
            isMine = it.isMine
        )}
}