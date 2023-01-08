package com.iwfsg.board.domain.post.service

import com.iwfsg.board.domain.comment.repository.CommentRepository
import com.iwfsg.board.domain.comment.util.CommentValidator
import com.iwfsg.board.domain.like.repository.LikeRepository
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.repository.CategoryRepository
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.impl.PostQueryServiceImpl
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import com.iwfsg.board.domain.test_utils.TestUtil
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.repository.UserRepository
import com.iwfsg.board.domain.user.utils.UserUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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
    private lateinit var commentValidator: CommentValidator
    private lateinit var commentRepository: CommentRepository
    private lateinit var postQueryConverter: PostQueryConverter
    private lateinit var categoryRepository: CategoryRepository
    private lateinit var userUtils: UserUtils
    private lateinit var target: PostQueryService

    @BeforeEach
    fun setUp() {
        postRepository = mock()
        postViewsRepository = mock()
        postQueryConverter = mock()
        userUtils = mock()
        commentValidator = mock()
        categoryRepository = mock()
        likeRepository = mock()
        commentRepository = mock()
        target = PostQueryServiceImpl(postRepository, postViewsRepository, commentValidator, userUtils, likeRepository, categoryRepository, commentRepository, postQueryConverter)
    }
    @ParameterizedTest
    @CsvSource(value = ["idx,DESC", "idx,ASC", "createdAt,DESC", "createdAt, ASC"])
    fun test_findAllPost(sortBy: String, direction: String){
        //given
        val page = Random.nextInt().absoluteValue
        val size = (1..100).random()
        val pagination = PageRequest.of(page, size,Sort.by(sortBy,direction))
        val posts = (1..size).map{TestUtil.data().post().entity()}
        val likeCount = Random.nextLong().absoluteValue
        val data = PageImpl(posts)
        val queryDto = mock<PostQueryDto>()

        //when
        whenever(postRepository.findBy(pagination)).thenReturn(data)
        whenever(postViewsRepository.findById(any())).thenReturn(Optional.empty())
        whenever(likeRepository.countByPost(any())).thenReturn(likeCount)
        whenever(postQueryConverter.toQueryDto(any(), any(), any())).thenReturn(queryDto)

        //then
        val result = target.findAllPost(pagination)
        assert(result.content.stream().allMatch{ it==queryDto})
    }
    @Test
    fun test_findPostByIdx(){
        //given
        val idx = Random.nextLong().absoluteValue
        val post = mock<Post>()
        val user = mock<User>()
        val content = (1..10).map {TestUtil.data().comment().entity()}
        val category = emptyList<String>()
        val likeCount = Random.nextLong().absoluteValue
        val queryDto = mock<PostQueryDto>()
        val returnDto = mock<DetailPostQueryDto>()

        //when
        whenever(userUtils.getCurrentUser()).thenReturn(user)
        whenever(postRepository.findById(idx)).thenReturn(Optional.empty())
        whenever(likeRepository.existsByUser(user)).thenReturn(false)
        whenever(categoryRepository.findCategoriesByPost(post).map { it.title }).thenReturn(category)
        whenever(postViewsRepository.findById(idx)).thenReturn(Optional.empty())
        whenever(commentRepository.findByIdx(idx)).thenReturn(content)
        whenever(likeRepository.countByPost(any())).thenReturn(likeCount)
        whenever(postQueryConverter.toQueryDto(any(), any(), any())).thenReturn(queryDto)
        whenever(postQueryConverter.toDetailQueryDto(any(), any(), any(), any(), any(), any())).thenReturn(returnDto)

        //then
         val result = target.findPostByIdx(idx)
        assertEquals(result, returnDto)
    }
}