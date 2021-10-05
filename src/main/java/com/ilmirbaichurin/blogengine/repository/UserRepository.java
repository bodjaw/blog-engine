package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
