package com.ilmirbaichurin.blogengine.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilmirbaichurin.blogengine.api.response.dto.TagDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TagResponse {

    @JsonProperty("tags")
    private List<TagDTO> tagResponse = new ArrayList<>();

    public void add(String name, double weight) {
        tagResponse.add(new TagDTO(name, weight));
    }

}
