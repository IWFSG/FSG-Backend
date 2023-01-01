package com.iwfsg.board.domain.post.service

import com.iwfsg.board.domain.like.repository.LikeRepository
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.impl.PostQueryServiceImpl
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import com.iwfsg.board.domain.test_utils.TestUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random

class PostQueryServiceTest {
    private lateinit var postRepository: PostRepository
    private lateinit var postViewsRepository: PostViewsRepository
    private lateinit var likeRepository: LikeRepository
    private lateinit var postQueryConverter: PostQueryConverter
    private lateinit var target: PostQueryService

    @BeforeEach
    fun setUp() {
        postRepository = mock()
        postViewsRepository = mock()
        postQueryConverter = mock()
        likeRepository = mock()
        target = PostQueryServiceImpl(postRepository, postViewsRepository, likeRepository, postQueryConverter)
    }
    @Test
    fun test_findAllPost(){
        //given
        val page = Random.nextInt().absoluteValue
        val size = (1..100).random()
        val sortingPagination = PageRequest.of(page, size, Sort.by(Sort.Order.desc("createdAt")))
        val posts = (1..size).map{TestUtil.data().post().entity()}
        val likeCount = Random.nextLong().absoluteValue
        val data = PageImpl(posts)
        val queryDto = mock<PostQueryDto>()

        //when
        whenever(postRepository.findBy(sortingPagination)).thenReturn(data)
        whenever(postViewsRepository.findById(any())).thenReturn(Optional.empty())
        whenever(likeRepository.countByPost(any())).thenReturn(likeCount)
        whenever(postQueryConverter.toQueryDto(any(), any(), any())).thenReturn(queryDto)

        //then
        val result = target.findAllPost(sortingPagination)
        assert(result.content.stream().allMatch{ it==queryDto})
    }
}