package com.iwfsg.board.domain.post.repository

import com.iwfsg.board.domain.post.entity.Category
import com.iwfsg.board.domain.post.entity.Post
import org.springframework.data.repository.CrudRepository

interface CategoryRepository: CrudRepository<Category, Long> {
    fun findCategoriesByPost(post: Post): List<Category>
}