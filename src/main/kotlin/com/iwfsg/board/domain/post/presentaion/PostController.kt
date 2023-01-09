package com.iwfsg.board.domain.post.presentaion

import com.iwfsg.board.domain.post.presentaion.data.request.CreatePostRequest
import com.iwfsg.board.domain.post.service.PostService
import com.iwfsg.board.domain.post.utils.PostConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/post")
class PostController(
    private val postConverter: PostConverter,
    private val postService: PostService
) {
    @PostMapping
    fun createPost(@Valid @RequestBody createPostRequest: CreatePostRequest): ResponseEntity<Void>{

    }
}