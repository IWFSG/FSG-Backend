package com.iwfsg.board.domain.post.presentaion

import com.iwfsg.board.domain.post.presentaion.data.response.PageablePostSummaryQueryResponse
import com.iwfsg.board.domain.post.service.PostQueryService
import com.iwfsg.board.domain.post.utils.PostQueryConverter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/post/query")
class PostQueryController(
    private val postQueryConverter: PostQueryConverter,
    private val postQueryService: PostQueryService
){
    @GetMapping
    fun findAllPostWithPagination(
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("size", defaultValue = "5") size: Int,
        @RequestParam("sort_by")sortBy: String,
        @RequestParam("direction")direction:String
    )
    : ResponseEntity<PageablePostSummaryQueryResponse> =
        postQueryService.findAllPost(PageRequest.of(page,size, Sort.by(sortBy,direction)))
            .map { postQueryConverter.toSummaryQueryResponse(it) }
            .let { postQueryConverter.toPageableResponse(it.toList()) }
            .let { ResponseEntity.ok().body(it) }
}