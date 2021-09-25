package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.TagResponse;

public interface TagService {

    TagResponse getTags(String query);

}
