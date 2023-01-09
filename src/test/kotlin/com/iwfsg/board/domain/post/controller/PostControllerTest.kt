package com.iwfsg.board.domain.post.controller

import com.iwfsg.board.domain.post.presentaion.PostController
import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto
import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest
import com.iwfsg.board.domain.post.service.PostService
import com.iwfsg.board.domain.post.utils.PostConverter
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class PostControllerTest {
    private lateinit var postConverter: PostConverter
    private lateinit var postService: PostService
    private lateinit var target: PostController

    @BeforeEach
    fun setUp() {
        postConverter = mock()
        postService = mock()
        target = PostController(postConverter,postService)
    }

    @Test
    @DisplayName("PostController - 게시물 생성 성공테스트")
    fun testCreatePost(){
        //given
        val request = mock<CreatePostRequest>()
        val dto = mock<PostDto>()

        //when
        whenever(postConverter.toDto(request)).thenReturn(dto)
        whenever(postService.createPost(dto)).thenReturn(null)

        val result = target.createPost(request)
        assert(result.statusCode.is2xxSuccessful)
        assertNull(result.body)
    }
}