package com.ilmirbaichurin.blogengine.dao.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilmirbaichurin.blogengine.dao.model.User;
import lombok.Data;

@Data
public class UserResponse {
    @JsonProperty("result")
    public boolean result;
    public User user;

    public UserResponse(boolean result) {
        this.result = result;
    }
}
