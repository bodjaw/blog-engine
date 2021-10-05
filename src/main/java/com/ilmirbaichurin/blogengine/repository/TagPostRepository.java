package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.model.LinksTagsWithPosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagPostRepository extends JpaRepository<LinksTagsWithPosts, Integer> {

    List<LinksTagsWithPosts> findByTagStartingWith(String query);
    List<LinksTagsWithPosts> findAll();

}
