package com.ilmirbaichurin.blogengine.model;

import com.ilmirbaichurin.blogengine.model.Post;
import com.ilmirbaichurin.blogengine.model.Tag;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tag2post")
@Data

public class LinksTagsWithPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
