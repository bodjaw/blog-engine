package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    @Query("SELECT p FROM Post p ORDER BY p.publicationTime DESC")
    Page<Post> findRecentPosts(Pageable pageable);

    @Query(value = "SELECT * FROM posts " +
            "LEFT JOIN post_comments pc ON posts.id = pc.post_id " +
            "GROUP BY (posts.id) ORDER BY COUNT(pc.post_id) DESC", nativeQuery = true)
    Page<Post> findPopularPosts(Pageable pageable);

    @Query(value = "SELECT * FROM posts " +
            "LEFT JOIN post_votes pv on posts.id = pv.post_id " +
            "GROUP BY posts.id ORDER BY SUM(pv.value) DESC", nativeQuery = true)
    Page<Post> findBestPosts(Pageable pageable);

    @Query("SELECT p FROM Post p ORDER BY p.publicationTime")
    Page<Post> findEarlyPosts(Pageable pageable);

}