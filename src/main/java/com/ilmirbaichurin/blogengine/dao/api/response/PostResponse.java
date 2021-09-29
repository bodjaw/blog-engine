package com.ilmirbaichurin.blogengine.dao.api.response;

import com.ilmirbaichurin.blogengine.dao.api.response.dto.PostsDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostResponse {

    private long postCount;
    private List<PostsDTO> posts = new ArrayList<>();

    public PostResponse() {
    }

    public void add(PostsDTO post) {
        posts.add(post);
    }
}
