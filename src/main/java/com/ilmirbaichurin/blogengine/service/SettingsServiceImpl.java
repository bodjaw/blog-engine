package com.ilmirbaichurin.blogengine.service;

import com.ilmirbaichurin.blogengine.api.response.SettingsResponse;
import com.ilmirbaichurin.blogengine.model.GlobalSetting;
import com.ilmirbaichurin.blogengine.model.enums.GlobalSettingValue;
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
        boolean isMultiuserMode = false;
        boolean isPostPreModeration = false;
        boolean isStatisticsIsPublic = false;
        for (GlobalSetting setting : globalSettings) {
            if (setting.getName().equals(GlobalSettingValue.MULTIUSER_MODE.getName())) {
                isMultiuserMode = settingModeConverter(setting.getValue());
            }
            if (setting.getName().equals(GlobalSettingValue.POST_PREMODERATION.getName())) {
                isPostPreModeration = settingModeConverter(setting.getValue());
            }
            if (setting.getName().equals(GlobalSettingValue.STATISTICS_IS_PUBLIC.getName())) {
                isStatisticsIsPublic = settingModeConverter(setting.getValue());
            }
        }
        return new SettingsResponse(isMultiuserMode, isPostPreModeration, isStatisticsIsPublic);
    }

    private boolean settingModeConverter(String mode) {
        return mode.equals("YES");
    }
}
