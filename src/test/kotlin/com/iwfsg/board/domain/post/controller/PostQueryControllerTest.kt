package com.iwfsg.board.domain.post.controller

import com.iwfsg.board.domain.post.presentaion.PostQueryController
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import com.iwfsg.board.domain.test_utils.TestUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import kotlin.math.absoluteValue
import kotlin.random.Random

class PostQueryControllerTest {
    private lateinit var postQueryConverter: PostQueryConverter
    private lateinit var postQueryService: PostQueryService
    private lateinit var target: PostQueryController

    @BeforeEach
    fun setUp() {
        postQueryConverter = mock()
        postQueryService = mock()
        target = PostQueryController(postQueryConverter,postQueryService)
    }
    @Test @DisplayName("PostQueryController- 전체게시물 조회 성공테스트")
    fun testFindAllPostWithPagination() {
        //given
        val page = Random.nextInt().absoluteValue
        val size = (1..100).random()
        val pagination = PageRequest.of(page, size)
        val posts = (1..100).map{ TestUtil.data().post().queryDto()}
        val data = PageImpl(posts)
        val response = mock<PostQueryResponse>()
        val pageableResponse = mock<PageablePostSummaryQueryResponse>()

        //when
        whenever(postQueryService.findAllPost(pagination)).thenReturn(data)
        whenever(postQueryConverter.toSummaryQueryResponse(any())).thenReturn(response)
        whenever(postQueryConverter.toPageableResponse(any())).thenReturn(pageableResponse)

        //then
        val result = target.findAllPostWithPagination(page,size)
        assert(result.statusCode.is2xxSuccessful)
        assert(result.hasBody())
        assertEquals(result.body, pageableResponse)
    }
}