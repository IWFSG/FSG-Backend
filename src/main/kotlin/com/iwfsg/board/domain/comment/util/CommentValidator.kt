package com.iwfsg.board.domain.comment.util

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.user.entity.User

interface CommentValidator {
    fun verifyCommentOwner(comment: Comment, user: User): DetailPostQueryDto.Comment
}