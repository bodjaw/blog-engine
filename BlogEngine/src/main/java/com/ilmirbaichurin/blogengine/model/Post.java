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
    private Integer id;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "moderation_status")
    private ModerationStatus moderationStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "moderator_id")
    private User moderator;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "time")
    private LocalDateTime publicationTime;
    private String title;
    private String text;
    @Column(name = "view_count")
    private Integer viewCount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tag2post",
    joinColumns = @JoinColumn(name = "tag_id"),
    inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Tag> postTags;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostVote> votes;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> comments;




}
