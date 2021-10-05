package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.api.response.PostResponse;

public interface PostService {

    PostResponse getPostsInfo(int offset, int limit, String mode);

}
