package com.iwfsg.board.domain.post.repository

import com.iwfsg.board.domain.post.entity.Views
import org.springframework.data.repository.CrudRepository

interface PostViewsRepository: CrudRepository<Views,Long> {
}