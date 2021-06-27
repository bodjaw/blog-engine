package com.ilmirbaichurin.blogengine.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tag2post")
@Data
public class LinksTagsWithPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer linkId;
    @Column(name = "post_id", nullable = false)
    private Integer postId;
    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

}
