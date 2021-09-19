package com.ilmirbaichurin.blogengine.dao.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "is_active")
    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    @Type(type = "org.hibernate.type.EnumType")
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

    public long getLikesCount() {
        return votes.stream().filter(PostVote::getValue).count();
    }

    public long getDislikesCount() {
        return votes.stream().filter(postVote -> !postVote.getValue()).count();
    }

}
