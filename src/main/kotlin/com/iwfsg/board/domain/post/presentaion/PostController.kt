package com.iwfsg.board.domain.post.presentaion

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/post")
class PostController {
    @PostMapping
    fun createPost(){

    }
}