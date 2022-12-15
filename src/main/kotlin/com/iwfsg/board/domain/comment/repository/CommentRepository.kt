package com.iwfsg.board.domain.comment.repository

import com.iwfsg.board.domain.comment.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository


interface CommentRepository: JpaRepository<Comment,Long> {

}