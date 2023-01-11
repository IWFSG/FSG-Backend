package com.iwfsg.board.domain.post.utils

import com.iwfsg.board.domain.post.entity.Category
import com.iwfsg.board.domain.post.entity.Post


interface CategoryConverter {
    fun toEntity(categoryName: String, post: Post): Category
}