package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.dao.model.LinksTagsWithPosts;
import com.ilmirbaichurin.blogengine.dao.model.Post;
import com.ilmirbaichurin.blogengine.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface TagPostRepository extends JpaRepository<LinksTagsWithPosts, Integer> {

    List<LinksTagsWithPosts> findByTagStartingWith(String query);
    List<LinksTagsWithPosts> findAll();

}
