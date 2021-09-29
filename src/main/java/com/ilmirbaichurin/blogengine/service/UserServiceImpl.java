package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.UserResponse;
import com.ilmirbaichurin.blogengine.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse getAuthInfo() {
        return new UserResponse(false);
    }

    @Override
    public Boolean getAuthCheck() {
        return false;
    }
}
