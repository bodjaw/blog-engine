CREATE TABLE users
(
    id           int          NOT NULL AUTO_INCREMENT,
    is_moderator tinyint      NOT NULL,
    reg_time     datetime     NOT NULL,
    name         varchar(255) NOT NULL,
    email        varchar(255) NOT NULL,
    password     varchar(255) NOT NULL,
    code         varchar(255),
    photo        text,
    PRIMARY KEY (id)
);

CREATE TABLE posts
(
    id                int                                  NOT NULL AUTO_INCREMENT,
    is_active         tinyint                              NOT NULL,
    moderation_status ENUM ('NEW', 'ACCEPTED', 'DECLINED') NOT NULL DEFAULT 'NEW',
    moderator_id      int,
    user_id           INT                                  NOT NULL,
    time              DATETIME                             NOT NULL,
    title             VARCHAR(255)                         NOT NULL,
    text              TEXT                                 NOT NULL,
    view_count        INT                                  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post_votes
(
    id      int      NOT NULL AUTO_INCREMENT,
    user_id INT      NOT NULL,
    post_id INT      NOT NULL,
    time    DATETIME NOT NULL,
    value   TINYINT  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tags
(
    id   int          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tag2post
(
    id      int NOT NULL AUTO_INCREMENT,
    post_id INT NOT NULL,
    tag_id  INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE post_comments
(
    id        int      NOT NULL AUTO_INCREMENT,
    parent_id INT,
    post_id   INT      NOT NULL,
    user_id   INT      NOT NULL,
    tag_id    INT      NOT NULL,
    time      DATETIME NOT NULL,
    text      TEXT     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE captcha_codes
(
    id          int      NOT NULL AUTO_INCREMENT,
    time        DATETIME NOT NULL,
    code        TINYTEXT NOT NULL,
    secret_code TINYTEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE global_settings
(
    id    int          NOT NULL AUTO_INCREMENT,
    code  VARCHAR(255) NOT NULL,
    name  VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);