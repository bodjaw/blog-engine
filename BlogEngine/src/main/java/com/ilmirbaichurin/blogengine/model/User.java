package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "is_moderator", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isModerator;
    @Column(name = "reg_time", nullable = false)
    private LocalDateTime timeDateOfRegistration;
    @Column(name = "name")
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String code;
    @Column(columnDefinition = "TEXT")
    private String photo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Post post;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "likedDislikedUser")
    private List<PostVote> userPostVotes;
    @OneToMany(mappedBy = "userComment", cascade = CascadeType.ALL)
    private List<Comment> userComments;
}
