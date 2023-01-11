package com.iwfsg.board.domain.post.service

import com.iwfsg.board.domain.post.entity.Category
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.entity.Views
import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.repository.CategoryRepository
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.impl.PostServiceImpl
import com.iwfsg.board.domain.post.utils.CategoryConverter
import com.iwfsg.board.domain.post.utils.PostConverter
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.utils.UserUtils
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class PostServiceTest {
    private lateinit var postConverter: PostConverter
    private lateinit var postRepository: PostRepository
    private lateinit var categoryRepository: CategoryRepository
    private lateinit var viewsRepository: PostViewsRepository
    private lateinit var categoryConverter: CategoryConverter
    private lateinit var userUtils: UserUtils
    private lateinit var target: PostService

    @BeforeEach
    fun setUp(){
        postConverter = mock()
        postRepository = mock()
        categoryRepository = mock()
        viewsRepository = mock()
        userUtils = mock()
        categoryConverter = mock()
        target = PostServiceImpl(postConverter,postRepository,userUtils,viewsRepository,categoryRepository,categoryConverter)
    }

    @Test
    @DisplayName("PostService - 게시물 생성 성공테스트")
    fun testCreatePost() {
        //given
        val user = mock<User>()
        val dto = mock<PostDto>()
        val post = mock<Post>()
        val category = listOf(mock<Category>())
        val views = mock<Views>()

        //when
        whenever(postConverter.toEntity(dto, user)).thenReturn(post)
        whenever(postRepository.save(post)).thenReturn(post)
        whenever(dto.category.map { categoryConverter.toEntity(it, post) }).thenReturn(category)
        whenever(categoryRepository.saveAll(category)).thenReturn(category)
        whenever(viewsRepository.save(views)).thenReturn(views)
    }
}