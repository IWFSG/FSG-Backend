package com.iwfsg.board.domain.post.service.impl

import com.iwfsg.board.domain.comment.repository.CommentRepository
import com.iwfsg.board.domain.comment.util.CommentValidator
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
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postViewsRepository: PostViewsRepository,
    private val postValidator: CommentValidator,
    private val userUtils: UserUtils,
    private val likeRepository: LikeRepository,
    private val categoryRepository: CategoryRepository,
    private val commentRepository: CommentRepository,
    private val postQueryConverter: PostQueryConverter
): PostQueryService {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        val posts = postRepository.findBy(pagination)
        return posts.map {
            val likeCount = getLikeCount(it)
            val views = findPostViewsByPostIdx(it.idx)
            return@map postQueryConverter.toQueryDto(views.viewCount, it,likeCount)
        }
    }
    @Transactional(rollbackFor = [Exception::class])
    override fun findPostByIdx(idx: Long): DetailPostQueryDto {
        val user = userUtils.getCurrentUser()
        val post = postRepository.findPostByIdx(idx).orElseThrow{PostNotFoundException()}
        val isMine = verifyPostOwner(post, user)
        val isLiked = likeRepository.existsByUser(user)
        val comment = commentRepository.findByIdx(idx).map { postValidator.verifyCommentOwner(it,user) }
        val category = categoryRepository.findCategoriesByPost(post).map { it.title }
        val views = findPostViewsByPostIdx(idx)
        val likeCount = getLikeCount(post)

        views.increaseViewCount()
        postViewsRepository.save(views)

        return postQueryConverter.toQueryDto(views.viewCount, post, likeCount)
            .let { postQueryConverter.toDetailQueryDto(it,isLiked, isMine, comment, category, user.name)}
    }
    private fun findPostViewsByPostIdx(idx: Long): Views =
        postViewsRepository.findById(idx).orElse(Views(idx, 0))
    private fun getLikeCount(post: Post): Long =
        likeRepository.countByPost(post)
    private fun verifyPostOwner(post: Post, user: User): Boolean =
        Objects.equals(post.user.idx, user.idx)
}