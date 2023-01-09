package com.iwfsg.board.domain.post.service

import com.iwfsg.board.domain.post.presentaion.data.dto.PostDto

interface PostService {
    fun createPost(dto: PostDto)
}