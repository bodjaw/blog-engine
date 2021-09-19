package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.PostResponse;
import com.ilmirbaichurin.blogengine.dao.api.response.PostsIndex;
import com.ilmirbaichurin.blogengine.dao.model.Post;
import com.ilmirbaichurin.blogengine.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private static final String MODE_RECENT =  "recent";
    private static final String MODE_POPULAR = "popular";
    private static final String MODE_BEST =    "best";
    private static final String MODE_EARLY =   "early";
    private static final String ZONE_ID = "Europe/Moscow";
    private static final int ANNOUNCE_LENGTH = 150;

    private static final Map<String, Comparator<Post>> SORTING_MODES = new HashMap<>();

    static {
        SORTING_MODES.put(MODE_RECENT, Comparator.comparing(Post::getPublicationTime).reversed());
        SORTING_MODES.put(MODE_POPULAR, (p1, p2) -> Integer.compare(p2.getComments().size(), p1.getComments().size()));
        SORTING_MODES.put(MODE_BEST, (p1, p2) -> Integer.compare(p2.getVotes().size(), p1.getVotes().size()));
        SORTING_MODES.put(MODE_EARLY, Comparator.comparing(Post::getPublicationTime));
    }

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponse getPostsInfo(int offset, int limit, String mode) {
        List<Post> posts = postRepository.findAll();
        PostResponse postResponse = new PostResponse();
        if(posts.isEmpty()) {
            return postResponse;
        }
        int count = posts.size();
        postResponse.setPostCount(count);
        int inxOfLast = count - 1;
        if (offset < 0 || offset > inxOfLast) {
            throw new RuntimeException("Invalid offset parameter.");
        }
        List<Post> postsForResponse = sortPosts(posts, mode);
        if (offset == 0) {
            return fillResponse(postsForResponse.subList(0, limit), postResponse); // при первом запросе
        } else {
            if((inxOfLast - offset) < limit) {
                return fillResponse(postsForResponse.subList(offset, inxOfLast + 1), postResponse);
            } else {
                return fillResponse(postsForResponse.subList(offset, limit + 1), postResponse);
            }
        }
    }

    private List<Post> sortPosts(List<Post> posts, String mode) {
        return posts.stream().sorted(SORTING_MODES.get(mode)).collect(Collectors.toList());
    }

    private PostResponse fillResponse(List<Post> posts, PostResponse postResponse) {

        posts.forEach(post -> {
            PostsIndex postsIndex = new PostsIndex.Builder()
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
            postResponse.add(postsIndex);
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
