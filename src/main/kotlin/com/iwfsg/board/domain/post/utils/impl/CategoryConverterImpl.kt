package com.iwfsg.board.domain.post.utils.impl

import com.iwfsg.board.domain.post.entity.Category
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.utils.CategoryConverter
import org.springframework.stereotype.Component

@Component
class CategoryConverterImpl: CategoryConverter {
    override fun toEntity(categoryName: String, post: Post): Category = Category(
        title = categoryName,
        post = post
    )
}