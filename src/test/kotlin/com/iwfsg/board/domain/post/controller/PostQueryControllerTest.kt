package com.iwfsg.board.domain.post.controller

import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import kotlin.math.absoluteValue
import kotlin.random.Random

class PostQueryControllerTest {
    @BeforeEach
    fun setUp() {
        val postQueryService: PostQueryService = mock()
        val postQueryConverter :PostQueryConverter = mock()
    }
    @Test @DisplayName("PostQueryController- 전체게시물 조회 성공테스트")
    fun testFindAllPostWithPagination() {
        //given
        val page = Random.nextInt().absoluteValue
        val size = (1..100).random()
        val pagination = PageRequest.of(page, size)
    }
}