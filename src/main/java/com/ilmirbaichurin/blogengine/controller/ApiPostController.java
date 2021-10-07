package com.ilmirbaichurin.blogengine.controller;

import com.ilmirbaichurin.blogengine.api.response.PostResponse;
import com.ilmirbaichurin.blogengine.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;

@Controller
@RequestMapping("/api/post")
@Validated
public class ApiPostController {

    private final PostService postService;

    @Autowired
    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    //возвращет посты со всей сопутствующей информацией для главной страницы
    @GetMapping
    public ResponseEntity<PostResponse> posts(@RequestParam(value = "offset", defaultValue = "0") @Min(0) int offset,
                                              @RequestParam(value = "limit", defaultValue = "10") @Min(0) int limit,
                                              @RequestParam("mode") String mode) {
        PostResponse response = postService.getPostsInfo(offset, limit, mode);
        return ResponseEntity.ok(response);
    }
}
