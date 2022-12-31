package com.iwfsg.board.domain.post.repository

import com.iwfsg.board.domain.post.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post,Long> {
    fun findBy(pageable: Pageable): Page<Post>
}