package com.ilmirbaichurin.blogengine.dao.api.response.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAuthCheckDTO {

    private int id;
    private String name;
    private String photo;
    private String email;
    @JsonProperty("moderation")
    private boolean isModeration;
    private int moderationCount;
    private boolean settings;

}
