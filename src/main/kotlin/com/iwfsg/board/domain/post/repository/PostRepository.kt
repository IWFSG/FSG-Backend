package com.iwfsg.board.domain.post.repository

import com.iwfsg.board.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post,Long> {
}