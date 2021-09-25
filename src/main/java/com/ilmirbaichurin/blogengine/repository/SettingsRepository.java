package com.ilmirbaichurin.blogengine.repository;

import com.ilmirbaichurin.blogengine.dao.model.GlobalSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<GlobalSetting, Integer> {
}
