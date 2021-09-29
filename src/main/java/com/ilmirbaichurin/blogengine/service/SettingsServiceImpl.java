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
        List<GlobalSetting> globalSettings = globalSettingsRepository.findAll();
        boolean isMultiuserMode = settingModeConverter(globalSettings.get(0).getValue());
        boolean isPostPreModeration = settingModeConverter(globalSettings.get(1).getValue());
        boolean isStatisticsIsPublic = settingModeConverter(globalSettings.get(2).getValue());
        return new SettingsResponse(isMultiuserMode, isPostPreModeration, isStatisticsIsPublic);
    }

    private boolean settingModeConverter(String mode) {
        return mode.equals("YES");
    }
}
