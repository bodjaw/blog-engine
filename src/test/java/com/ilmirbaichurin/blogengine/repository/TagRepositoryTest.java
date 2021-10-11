package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.model.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@PropertySource("classpath:application.properties")
//@Sql(value = "classpath:sql/tags_posts_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TagRepositoryTest {

    @Autowired
    private TagRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    @Sql(value = "classpath:sql/tags_posts_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void itShouldCheckCountOfPostsWithThisTag() {
        assertThat(repository.countOfPostsWithThisTag("Python")).isZero();
        assertThat(repository.countOfPostsWithThisTag("Hibernate")).isEqualTo(1);
        assertThat(repository.countOfPostsWithThisTag("Java")).isEqualTo(5);
    }

    @Test
    @Sql(value = "classpath:sql/tags_posts_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void findAllSortedByCountOfPostAndStartWith() {
        List<Tag> tags = repository.findAllSortedByCountOfPostAndStartWith("Java");
        tags.forEach(tag -> System.out.println(tag.getName() + " " + tag.getPostsWithThisTag().size()));
        assertThat(tags).size().isEqualTo(2);
        assertThat(tags.get(0).getName()).isEqualTo("Java");
        assertThat(tags.get(1).getName()).isEqualTo("JavaStart");
    }

    @Test
    @Sql(value = "classpath:sql/tags_posts_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void countOfPostsWithThisTag() {
        List<Tag> tags = repository.findAllSortedByCountOfPost();
        tags.forEach(tag -> System.out.println(tag.getName() + " " + tag.getPostsWithThisTag().size()));
        assertThat(tags).size().isEqualTo(4);
        assertThat(tags.get(0).getName()).isEqualTo("Java");
        assertThat(tags.get(1).getName()).isEqualTo("Spring");
        assertThat(tags.get(2).getName()).isEqualTo("JavaStart");
        assertThat(tags.get(3).getName()).isEqualTo("Hibernate");
    }
}