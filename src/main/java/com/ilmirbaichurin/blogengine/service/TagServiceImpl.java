package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.TagResponse;
import com.ilmirbaichurin.blogengine.dao.model.LinksTagsWithPosts;
import com.ilmirbaichurin.blogengine.dao.model.Post;
import com.ilmirbaichurin.blogengine.dao.model.Tag;
import com.ilmirbaichurin.blogengine.repository.TagPostRepository;
import com.ilmirbaichurin.blogengine.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagPostRepository repository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, TagPostRepository repository) {
        this.tagRepository = tagRepository;
        this.repository = repository;
    }

    @Override
    public TagResponse getTags(String query) {
        TagResponse tagResponse = new TagResponse();
        List<Tag> tags;
        if (query == null) {
            tags = tagRepository.findAll(); //получение тегов, при пустом запросе
        } else {
            tags = tagRepository.findAllByNameStartsWith(query); //получение тегов начинающихся на query
        }
        if (tags.isEmpty()) {
            return tagResponse;
        }
        Map<Tag, List<Post>> tagPosts =  getTagPosts(tags);
        Tag mostPopularTag = tags.stream()
                .sorted((t1, t2) -> Integer.compare(t2.getPostsWithThisTag().size(), t1.getPostsWithThisTag().size()))
                .findFirst()
                .get();
        int postCount = tagPosts.values().stream().mapToInt(List::size).sum();
        double dWeightMax = (double) tagPosts.get(mostPopularTag).size() / postCount; //ненормированный вес самого популярного тега
        double k = (double) 1 / dWeightMax; //коэф. нормализации
        for (Map.Entry<Tag, List<Post>> links : tagPosts.entrySet()) {
            double dWeight = (double) links.getValue().size() / postCount;
            double normalizedWeight = k * dWeight;
            tagResponse.add(links.getKey().getName(), normalizedWeight);
        }
        tagResponse.getTagResponse().sort((o1, o2) -> Double.compare(o2.getWeight(), o1.getWeight()));
        return tagResponse;
    }

    private Map<Tag, List<Post>> getTagPosts(List<Tag> tags) {
        Map<Tag, List<Post>> tagPosts = new HashMap<>();
        tags.forEach(i -> tagPosts.put(i, new ArrayList<>()));

        List<LinksTagsWithPosts> list = repository.findAll();
        list.forEach(i -> {
            if (tagPosts.containsKey(i.getTag())) {
                List<Post> posts = tagPosts.get(i.getTag());
                posts.add(i.getPost());
            }
        });
        return tagPosts;
    }
}