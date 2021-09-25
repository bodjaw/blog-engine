package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.dao.api.response.SettingsResponse;
import com.ilmirbaichurin.blogengine.dao.model.GlobalSetting;
import com.ilmirbaichurin.blogengine.repository.SettingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl implements SettingService {

    private final SettingsRepository globalSettingsRepository;

    public SettingsServiceImpl(SettingsRepository globalSettingsRepository) {
        this.globalSettingsRepository = globalSettingsRepository;
    }

    @Override
    public SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        List<GlobalSetting> globalSettings = globalSettingsRepository.findAll();
        boolean isMultiuserMode = false;
        boolean isPostPreModeration = false;
        boolean isStatisticsIsPublic = false;
        if (globalSettings.get(0).getValue().equals("YES")) {
            isMultiuserMode = true;
        }
        if (globalSettings.get(1).getValue().equals("YES")) {
            isPostPreModeration = true;
        }
        if (globalSettings.get(2).getValue().equals("YES")) {
            isStatisticsIsPublic = true;
        }

        settingsResponse.setMultiuserMode(isMultiuserMode);
        settingsResponse.setPostPremoderation(isPostPreModeration);
        settingsResponse.setStatisticsIsPublic(isStatisticsIsPublic);
        return settingsResponse;
    }
}
