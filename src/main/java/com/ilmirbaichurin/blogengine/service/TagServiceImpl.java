package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.api.response.TagResponse;
import com.ilmirbaichurin.blogengine.model.Tag;
import com.ilmirbaichurin.blogengine.repository.PostRepository;
import com.ilmirbaichurin.blogengine.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, PostRepository postRepository) {
        this.tagRepository = tagRepository;
        this.postRepository = postRepository;
    }

    @Override
    public TagResponse getTags(String query) {

//        tagRepository.test(JpaSort.unsafe("COUNT(p.id)")).forEach(tag -> System.out.println(tag.getName()));

        System.out.println("__________________________");
        tagRepository.findAllSortedByCountOfPost().forEach(tag -> System.out.println(tag.getName()));
        System.out.println("__________________________");
        TagResponse tagResponse = new TagResponse();
        List<Tag> tags;
        if (query == null) {
            tags = tagRepository.findAllSortedByCountOfPost();
        } else {
            tags = tagRepository.findAllSortedByCountOfPostAndStartWith(query);
        }
        if (tags.isEmpty()) {
            return tagResponse;
        }
        Tag mostPopularTag = tags.get(0); // 0-й элемент, т.к. tags отсортирован
        long postCount = postRepository.count();
        double dWeightMax = (double) mostPopularTag.getPostsWithThisTag().size() / postCount; //ненормированный вес поп.тэга
        double k = (double) 1 / dWeightMax;                                                   //коэф. нормализации
        tags.forEach(tag -> {
            double dWeight = (double) tagRepository.countOfPostsWithThisTag(tag.getName()) / postCount;
            double normalizedWeight = k * dWeight;
            tagResponse.add(tag.getName(), normalizedWeight);
        });
        return tagResponse;
    }
}