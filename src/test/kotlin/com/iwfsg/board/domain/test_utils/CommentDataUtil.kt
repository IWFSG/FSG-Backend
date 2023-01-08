package com.iwfsg.board.domain.test_utils

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.post.entity.Post

object CommentDataUtil {
    private fun content() = listOf("댓글1","댓글2","댓글3").random()

    fun entity() = Comment(
        content = content(),
        user = TestUtil.data().user().entity(),
        post = TestUtil.data().post().entity()
    )
}