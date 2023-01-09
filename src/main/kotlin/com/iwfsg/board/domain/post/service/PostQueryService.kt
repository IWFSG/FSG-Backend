package com.iwfsg.board.domain.post.service

import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface PostQueryService {
    fun findAllPost(pagination: PageRequest): Page<PostQueryDto>
    fun findPostByIdx(idx: Long): DetailPostQueryDto
}