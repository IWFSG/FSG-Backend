package com.iwfsg.board.domain.post.controller

import com.iwfsg.board.domain.post.presentaion.PostQueryController
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.response.DetailPostQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.presentaion.data.response.PostQueryResponse
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import com.iwfsg.board.domain.test_utils.TestUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
    @DisplayName("PostQueryController-전체게시물 조회 성공테스트")
    @ParameterizedTest
    @CsvSource(value = ["idx,DESC", "idx,ASC", "createdAt,DESC", "createdAt, ASC"])
    fun testFindAllPostWithPagination(sortBy: String, direction: String) {
        //given
        val page = Random.nextInt().absoluteValue
        val size = (1..100).random()
        val pagination = PageRequest.of(page, size,Sort.by(sortBy,direction))
        val posts = (1..100).map{ TestUtil.data().post().queryDto()}
        val data = PageImpl(posts)
        val response = mock<PostQueryResponse>()
        val pageableResponse = mock<PageablePostSummaryQueryResponse>()

        //when
        whenever(postQueryService.findAllPost(pagination)).thenReturn(data)
        whenever(postQueryConverter.toSummaryQueryResponse(any())).thenReturn(response)
        whenever(postQueryConverter.toPageableResponse(any())).thenReturn(pageableResponse)

        //then
        val result = target.findAllPostWithPagination(page,size,sortBy,direction)
        assert(result.statusCode.is2xxSuccessful)
        assert(result.hasBody())
        assertEquals(result.body, pageableResponse)
    }
    @DisplayName("PostQueryController-상세피이지 조회 성공테스트")
    @Test
    fun testFindPostByIdx(){
        //given
        val postIdx = Random.nextLong()
        val dto = mock<DetailPostQueryDto>()
        val response = mock<DetailPostQueryResponse>()

        //when
        whenever(postQueryService.findPostByIdx(postIdx)).thenReturn(dto)
        whenever(postQueryConverter.toQueryResponse(dto)).thenReturn(response)

        //then
        val result = target.findPostByIdx(postIdx)
        assert(result.statusCode.is2xxSuccessful)
        assert(result.hasBody())
        assertEquals(result.body, response)
    }
}