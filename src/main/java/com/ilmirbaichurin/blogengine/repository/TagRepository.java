package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("SELECT t FROM Tag t JOIN LinksTagsWithPosts tp ON t.id = tp.id JOIN Post p on p.id = tp.id " +
            "GROUP BY t.id ORDER BY COUNT(p.id) DESC")
    List<Tag> findAllSortedByCountOfPost();

    @Query("SELECT t FROM Tag t JOIN LinksTagsWithPosts tp on t.id = tp.id JOIN Post p on p.id = tp.id " +
            "WHERE t.name LIKE :query% GROUP BY t.id ORDER BY COUNT(p.id) DESC")
    List<Tag> findAllSortedByCountOfPostAndStartWith(@Param("query") String query);

    @Query(value = "SELECT * FROM tags " +
            "JOIN tag2post t2p on tags.id = t2p.tag_id " +
            "JOIN posts p on p.id = t2p.post_id " +
            "GROUP BY name ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
    Tag test();

    @Query(value = "SELECT COUNT(*) FROM tags " +
            "JOIN tag2post t2p on tags.id = t2p.tag_id " +
            "JOIN posts p on p.id = t2p.post_id WHERE tags.name = :tag",nativeQuery = true)
    long countOfPostsWithThisTag(@Param("tag") String tag);
}