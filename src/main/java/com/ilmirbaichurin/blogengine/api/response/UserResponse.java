package com.ilmirbaichurin.blogengine.api.response;

import com.ilmirbaichurin.blogengine.api.response.dto.UserAuthCheckDTO;
import lombok.Data;

@Data
public class UserResponse {
    public boolean result;
    public UserAuthCheckDTO user;

    public UserResponse(boolean result) {
        this.result = result;
    }
}
