package com.ilmirbaichurin.blogengine.dao.api.response.dto;

import lombok.Data;

@Data
public class PostsDTO {

    private int id;
    private long timestamp;
    private UserDTO user;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;

    public static class Builder {
        private PostsDTO postsDTO;

        public Builder() {
            postsDTO = new PostsDTO();
        }

        public Builder id(int id) {
            postsDTO.id = id;
            return this;
        }

        public Builder timestamp(long timestamp) {
            postsDTO.timestamp = timestamp;
            return this;
        }

        public Builder user(int id, String name) {
            postsDTO.user = new UserDTO(id, name);
            return this;
        }

        public Builder title(String title) {
            postsDTO.title = title;
            return this;
        }

        public Builder announce(String announce) {
            postsDTO.announce = announce;
            return this;
        }

        public Builder likeCount(int likeCount) {
            postsDTO.likeCount = likeCount;
            return this;
        }

        public Builder dislikeCount(int dislikeCount) {
            postsDTO.dislikeCount = dislikeCount;
            return this;
        }

        public Builder commentCount(int commentCount) {
            postsDTO.commentCount = commentCount;
            return this;
        }

        public Builder viewCount(int viewCount) {
            postsDTO.viewCount = viewCount;
            return this;
        }

        public PostsDTO build() {
            return postsDTO;
        }
    }
}


