package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentId;
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
    @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL)
    private Set<Comment> subComments = new HashSet<>();
}
