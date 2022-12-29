package com.iwfsg.board.domain.post.presentaion

import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostQueryController(
    private val postQueryConverter: PostQueryConverter,
    private val postQueryService: PostQueryService
){
    @GetMapping
    fun findAllPostWithPagination(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int)
    : ResponseEntity<PageablePostSummaryQueryResponse> =
        postQueryService.findAllPost(PageRequest.of(page,size))
            .map { postQueryConverter.toSummaryQueryResponse(it) }
            .let { postQueryConverter.toPageableResponse(it.toList()) }
            .let { ResponseEntity.ok().body(it) }
}