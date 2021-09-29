ALTER TABLE posts
    ADD FOREIGN KEY (user_id)
        REFERENCES users (id);

ALTER TABLE post_votes
    ADD FOREIGN KEY (user_id)
        REFERENCES users (id);

ALTER TABLE post_votes
    ADD FOREIGN KEY (post_id)
        REFERENCES posts (id);

ALTER TABLE tag2post
    ADD FOREIGN KEY (post_id)
        REFERENCES posts (id);

ALTER TABLE tag2post
    ADD FOREIGN KEY (tag_id)
        REFERENCES tags (id);

ALTER TABLE post_comments
    ADD FOREIGN KEY (post_id)
        REFERENCES posts (id);

ALTER TABLE post_comments
    ADD FOREIGN KEY (user_id)
        REFERENCES users (id);