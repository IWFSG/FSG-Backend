package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.like.repository.LikeRepository
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postViewsRepository: PostViewsRepository,
    private val likeRepository: LikeRepository,
    private val postQueryConverter: PostQueryConverter
): PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        val sort = Sort.by(Sort.Order.desc("createdAt"))
        val pageable = pagination.run {PageRequest.of(pageSize,pageSize,sort) }
        val posts = postRepository.findBy(pageable)
        return posts.map {
            val likeCount = getLikeCount(it)
            val views = findPostViewsByPostIdx(it.idx)
            return@map postQueryConverter.toQueryDto(views,it,likeCount)
        }
    }

    private fun findPostViewsByPostIdx(idx: Long): Long =
        postViewsRepository.findById(idx)
            .let { if(it.isEmpty) 0 else it.get().viewCount }
    private fun getLikeCount(post: Post): Long =
        likeRepository.countByPost(post)
}