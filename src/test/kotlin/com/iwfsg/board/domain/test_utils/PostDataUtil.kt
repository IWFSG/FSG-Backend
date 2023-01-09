package com.iwfsg.board.domain.test_utils

import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import java.time.ZonedDateTime
import kotlin.random.Random

object PostDataUtil {
    private fun title() = listOf("제목","제목1","제목2").random()
    private fun content() = listOf("내용","내용1","내용2").random()
    private fun thumbnail() = listOf("사진","사진1","사진2").random()

    fun queryDto() = PostQueryDto(
        idx = Random.nextLong(),
        title = title(),
        content = content(),
        thumbnail = thumbnail(),
        views = Random.nextLong(),
        likeCount = Random.nextLong(),
        createdAt = ZonedDateTime.now()
    )
    fun entity() = Post(
        title = title(),
        content = content(),
        thumbnail = thumbnail(),
        user = TestUtil.data().user().entity()
    )
}