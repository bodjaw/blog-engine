package com.ilmirbaichurin.blogengine.dao.api.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostResponse {

    private int postCount;
    private List<PostsIndex> posts = new ArrayList<>();

    public PostResponse() {
    }

    public void add(PostsIndex post) {
        posts.add(post);
    }
}
