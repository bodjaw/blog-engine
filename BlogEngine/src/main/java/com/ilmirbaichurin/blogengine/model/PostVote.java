package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_votes")
@Data
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Column(name = "post_id", nullable = false)
    private Integer postId;
    @Column(name = "time", nullable = false)
    private LocalDateTime dateTimeLikeOrDislike;
    @Column(name = "value", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean likeOrDislike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User likedDislikedUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post postLikeDislike;

}
