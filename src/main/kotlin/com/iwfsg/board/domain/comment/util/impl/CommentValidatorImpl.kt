package com.iwfsg.board.domain.comment.util.impl

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.comment.util.CommentValidator
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class CommentValidatorImpl: CommentValidator {
    override fun verifyCommentOwner(comment: Comment, user: User): DetailPostQueryDto.Comment {
        return if(comment.user.idx == user.idx){
            DetailPostQueryDto.Comment(
                idx = comment.idx,
                name = user.name,
                content = comment.content,
                isMine = true
            )
        }else{
            DetailPostQueryDto.Comment(
                idx = comment.idx,
                name = user.name,
                content = comment.content,
                isMine = true
            )
        }
    }
}