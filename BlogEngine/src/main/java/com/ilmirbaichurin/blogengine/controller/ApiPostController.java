package com.ilmirbaichurin.blogengine.controller;

import com.ilmirbaichurin.blogengine.dao.api.response.PostResponse;
import com.ilmirbaichurin.blogengine.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/post")
public class ApiPostController {

    private final PostService postService;

    @Autowired
    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    //возвращет посты со всей сопутствующей информацией для главной страницы
    @GetMapping
    public ResponseEntity<PostResponse> posts(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit,
                                              @RequestParam("mode") String mode) {
        return ResponseEntity.ok(postService.getPostsInfo(offset, limit, mode));
    }
}
