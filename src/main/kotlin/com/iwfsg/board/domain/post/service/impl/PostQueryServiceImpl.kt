package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.comment.entity.Comment
import com.iwfsg.board.domain.comment.repository.CommentRepository
import com.iwfsg.board.domain.like.repository.LikeRepository
import com.iwfsg.board.domain.post.entity.Post
import com.iwfsg.board.domain.post.entity.Views
import com.iwfsg.board.domain.post.exception.PostNotFoundException
import com.iwfsg.board.domain.post.presentaion.data.dto.DetailPostQueryDto
import com.iwfsg.board.domain.post.presentaion.data.dto.PostQueryDto
import com.iwfsg.board.domain.post.repository.CategoryRepository
import com.iwfsg.board.domain.post.repository.PostRepository
import com.iwfsg.board.domain.post.repository.PostViewsRepository
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import com.iwfsg.board.domain.user.entity.User
import com.iwfsg.board.domain.user.utils.UserUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postViewsRepository: PostViewsRepository,
    private val userUtils: UserUtils,
    private val likeRepository: LikeRepository,
    private val categoryRepository: CategoryRepository,
    private val commentRepository: CommentRepository,
    private val postQueryConverter: PostQueryConverter
): PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        val posts = postRepository.findBy(pagination)
        return posts.map {
            val likeCount = getLikeCount(it)
            val views = findPostViewsByPostIdx(it.idx)
            return@map postQueryConverter.toQueryDto(views,it,likeCount)
        }
    }

    override fun findPostByIdx(idx: Long): DetailPostQueryDto {
        val user = userUtils.getCurrentUser()
        val post = postRepository.findPostByIdx(idx).orElseThrow{PostNotFoundException()}
        val isMine = verifyPostOwner(post, user)
        val isLiked = likeRepository.existsByUser(user)
        val commentList = commentRepository.findByIdx(idx)
        val category = categoryRepository.findCategoriesByPost(post).map { it.title }
        val views = findPostViewsByPostIdx(idx)
        val likeCount = getLikeCount(post)

        increaseViews(idx)

        return postQueryConverter.toQueryDto(views, post, likeCount)
            .let { postQueryConverter.toDetailQueryDto(it,isLiked,isMine,commentList.map { comment -> verifyComment(comment,user) },category,user.name)}
    }

    private fun findPostViewsByPostIdx(idx: Long): Long =
        postViewsRepository.findById(idx)
            .let { if(it.isEmpty) 0 else it.get().viewCount }
    private fun getLikeCount(post: Post): Long =
        likeRepository.countByPost(post)
    private fun verifyPostOwner(post: Post, user: User): Boolean =
        Objects.equals(post.user.idx,user.idx)
    private fun verifyComment(comment: Comment,user: User): DetailPostQueryDto.Comment =
        if(comment.user.idx == user.idx){
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
    private fun increaseViews(postIdx: Long){
        val views = postViewsRepository.findById(postIdx).orElse(Views(postIdx, 0))
        views.increaseViewCount()
        postViewsRepository.save(views)
    }
}