package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    List<Tag> findAll();
    List<Tag> findAllByNameStartsWith(String query);
}
