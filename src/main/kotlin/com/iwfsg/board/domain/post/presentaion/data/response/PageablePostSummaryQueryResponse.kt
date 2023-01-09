package com.iwfsg.board.domain.post.presentaion.data.response

import org.springframework.data.domain.Page

data class PageablePostSummaryQueryResponse (
    val pageablePostList: Page<PostQueryResponse>
)