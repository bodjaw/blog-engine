package com.ilmirbaichurin.blogengine.dao.api.response;

import lombok.Data;

@Data
public class TagWithWeight {

    public TagWithWeight(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    private String name;
    private
    double weight;


}
