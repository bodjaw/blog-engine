package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer commentId;
    @Column(name = "parent_id")
    private Integer parentCommentId;
    @Column(name = "post_id", nullable = false)
    private Integer postId;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Column(name = "time", nullable = false)
    private LocalDateTime dateTimeComment;
    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String commentText;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User userComment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post postComment;
}
