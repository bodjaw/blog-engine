package com.ilmirbaichurin.blogengine.dao.api.response;

import lombok.Data;

@Data
public class PostsIndex {

    private int id;
    private long timestamp;
    private UserInfo user;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;

    public void setUserInfo(int id, String name) {
        this.user = new UserInfo(id, name);
    }

    @Data
    private static class UserInfo {

        private int id;
        private String name;

        public UserInfo(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Builder {
        private PostsIndex postsIndex;

        public Builder() {
            postsIndex = new PostsIndex();
        }

        public Builder id(int id) {
            postsIndex.id = id;
            return this;
        }

        public Builder timestamp(long timestamp) {
            postsIndex.timestamp = timestamp;
            return this;
        }

        public Builder user(int id, String name) {
            postsIndex.user = new UserInfo(id, name);
            return this;
        }

        public Builder title(String title) {
            postsIndex.title = title;
            return this;
        }

        public Builder announce(String announce) {
            postsIndex.announce = announce;
            return this;
        }

        public Builder likeCount(int likeCount) {
            postsIndex.likeCount = likeCount;
            return this;
        }

        public Builder dislikeCount(int dislikeCount) {
            postsIndex.dislikeCount = dislikeCount;
            return this;
        }

        public Builder commentCount(int commentCount) {
            postsIndex.commentCount = commentCount;
            return this;
        }

        public Builder viewCount(int viewCount) {
            postsIndex.viewCount = viewCount;
            return this;
        }

        public PostsIndex build() {
            return postsIndex;
        }
    }
}


