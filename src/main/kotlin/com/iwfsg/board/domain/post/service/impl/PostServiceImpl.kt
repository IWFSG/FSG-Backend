package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.repository.CategoryRepository
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.PostService
import com.iwfsg.board.domain.post.utils.CategoryConverter
import com.iwfsg.board.domain.post.utils.PostConverter
import com.iwfsg.board.domain.user.utils.UserUtils
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postConverter: PostConverter,
    private val postRepository: PostRepository,
    private val userUtils: UserUtils,
    private val viewsRepository: PostViewsRepository,
    private val categoryRepository: CategoryRepository,
    private val categoryConverter: CategoryConverter
): PostService {
    override fun createPost(dto: PostDto) {
        TODO("Not yet implemented")
    }
}