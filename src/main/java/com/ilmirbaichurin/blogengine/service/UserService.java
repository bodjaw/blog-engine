package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.UserResponse;

public interface UserService {

    UserResponse getAuthInfo();

    Boolean getAuthCheck();
}
