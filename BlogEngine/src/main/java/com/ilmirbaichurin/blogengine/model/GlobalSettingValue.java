package com.ilmirbaichurin.blogengine.model;

public enum GlobalSettingValue {
    MULTIUSER_MODE("Многопользовательский режим"),
    POST_PREMODERATION("Премодерация постов"),
    STATISTICS_IS_PUBLIC("Показывать всем статистику блога");

    private String settingName;
    private boolean isOn;

    GlobalSettingValue(String settingName) {
        this.settingName = settingName;
    }

    public String getName() {
        return settingName;
    }


}
