package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.dao.model.LinksTagsWithPosts;
import com.ilmirbaichurin.blogengine.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

}
