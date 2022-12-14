package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.DetailPostQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import org.springframework.data.domain.Page

interface PostQueryConverter {
    fun toQueryDto(views: Long, entity: Post, likeCount: Long): PostQueryDto
    fun toDetailQueryDto(dto: PostQueryDto, liked: Boolean, mined: Boolean, comment: List<DetailPostQueryDto.Comment>, category: List<String>,userName: String): DetailPostQueryDto
    fun toSummaryQueryResponse(dto: PostQueryDto): PostQueryResponse
    fun toPageableResponse(list: List<PostQueryResponse>): PageablePostSummaryQueryResponse
    fun toQueryResponse(dto: DetailPostQueryDto): DetailPostQueryResponse
}