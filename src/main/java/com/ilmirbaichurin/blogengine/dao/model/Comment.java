package com.ilmirbaichurin.blogengine.dao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Comment parent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime time;
    private String text;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> subComments;
}
