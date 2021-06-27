package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "is_active", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean isActive;
    @Column(name = "moderation_status", nullable = false)
    private ModerationStatus moderationStatus;
    @Column(name = "moderator_id")
    private Integer moderatorId;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Column(name = "time", nullable = false)
    private LocalDateTime timeDateOfPublication;
    @Column(name = "title", nullable = false)
    private String postTitle;
    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String postText;
    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tag2post",
    joinColumns = @JoinColumn(name = "tag_id"),
    inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Tag> postTags;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postLikeDislike")
    private List<PostVote> postLikesDislikes;

    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    private List<Comment> postComments;

}
