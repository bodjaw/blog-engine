package com.ilmirbaichurin.blogengine.dao.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilmirbaichurin.blogengine.dao.api.response.dto.TagWithWeight;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TagResponse {

    @JsonProperty("tags")
    private List<TagWithWeight> tagResponse = new ArrayList<>();

    public void add(String name, double weight) {
        tagResponse.add(new TagWithWeight(name, weight));
    }

}
