package com.ilmirbaichurin.blogengine.dao.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingsResponse {

    @JsonProperty("MULTIUSER_MODE")
    private final boolean multiuserMode;
    @JsonProperty("POST_PREMODERATION")
    private final boolean postPremoderation;
    @JsonProperty("STATISTICS_IS_PUBLIC")
    private final boolean statisticsIsPublic;

    public SettingsResponse(boolean multiuserMode, boolean postPremoderation, boolean statisticsIsPublic) {
        this.multiuserMode = multiuserMode;
        this.postPremoderation = postPremoderation;
        this.statisticsIsPublic = statisticsIsPublic;
    }
}

