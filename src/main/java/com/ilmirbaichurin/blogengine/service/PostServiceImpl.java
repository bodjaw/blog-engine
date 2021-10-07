package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.api.response.PostResponse;
import com.ilmirbaichurin.blogengine.api.response.dto.PostsDTO;
import com.ilmirbaichurin.blogengine.model.Post;
import com.ilmirbaichurin.blogengine.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final String MODE_RECENT =  "recent";
    private static final String MODE_POPULAR = "popular";
    private static final String MODE_BEST =    "best";
    private static final String MODE_EARLY =   "early";
    private static final String ZONE_ID = "Europe/Moscow";
    private static final int ANNOUNCE_LENGTH = 150;

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostResponse getPostsInfo(int offset, int limit, String mode) {
        PostResponse postResponse = new PostResponse();
        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Post> postPage = getSortedPosts(mode, pageRequest);
        List<Post> posts = null;
        if (postPage != null) {
            posts = postPage.getContent();
        }
        if(posts == null) {
            return postResponse;
        }
        long postsCount = postPage.getTotalElements();
        postResponse.setPostCount(postsCount);

        return fillResponse(posts, postResponse);
    }

    private Page<Post> getSortedPosts(String mode, PageRequest request) {
        if (mode.equals(MODE_EARLY)) {
            return repository.findEarlyPosts(request);
        }
        if (mode.equals(MODE_BEST)) {
            return repository.findBestPosts(request);
        }
        if (mode.equals(MODE_POPULAR)) {
            return repository.findPopularPosts(request);
        }
        if (mode.equals(MODE_RECENT)) {
            return repository.findRecentPosts(request);
        }
        return repository.findAll(request);
    }

    private PostResponse fillResponse(List<Post> posts, PostResponse postResponse) {
        posts.forEach(post -> {
            PostsDTO postsDTO = new PostsDTO.Builder()
                    .id(post.getId())
                    .timestamp(toMillis(post.getPublicationTime()))
                    .user(post.getUser().getId(), post.getUser().getName())
                    .title(post.getTitle())
                    .announce(getAnnounce(post.getText()))
                    .likeCount((int) post.getLikesCount())
                    .dislikeCount((int) post.getDislikesCount())
                    .commentCount(post.getComments().size())
                    .viewCount(post.getViewCount())
                    .build();
            postResponse.add(postsDTO);
        });
        return postResponse;
    }

    private long toMillis(LocalDateTime time) {
        return time.atZone(ZoneId.of(ZONE_ID)).toInstant().getEpochSecond();
    }

    private String getAnnounce(String text) {
        if (text.length() > ANNOUNCE_LENGTH) {
            return text.substring(0, ANNOUNCE_LENGTH) + "...";
        }
        return text;
    }
}
