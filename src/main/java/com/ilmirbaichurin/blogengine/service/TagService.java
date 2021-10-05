package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.api.response.TagResponse;

public interface TagService {

    TagResponse getTags(String query);

}
