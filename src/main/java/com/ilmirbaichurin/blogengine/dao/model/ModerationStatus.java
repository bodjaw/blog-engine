package com.ilmirbaichurin.blogengine.dao.model;

public enum ModerationStatus {
    NEW("NEW"),
    ACCEPTED("ACCEPTED"),
    DECLINED("DECLINED");

    private String name;

    ModerationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
