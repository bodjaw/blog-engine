package com.ilmirbaichurin.blogengine.controller;

import com.ilmirbaichurin.blogengine.api.response.InitResponse;
import com.ilmirbaichurin.blogengine.api.response.SettingsResponse;
import com.ilmirbaichurin.blogengine.api.response.TagResponse;
import com.ilmirbaichurin.blogengine.service.SettingService;
import com.ilmirbaichurin.blogengine.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final SettingService settingsService;
    private final TagService tagService;

    @Autowired
    public ApiGeneralController(InitResponse initResponse, SettingService settingsService, TagService tagService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.tagService = tagService;
    }

    //возвращает общую информацию о блоге
    //авторизация не требуется
    @GetMapping("/init")
    public ResponseEntity<InitResponse> init() {
        return ResponseEntity.ok(initResponse);
    }

    //возвращает глобальные настройки блога
    //авторизация не требуется
    @GetMapping("/settings")
    public ResponseEntity<SettingsResponse> settings() {
        return ResponseEntity.ok(settingsService.getGlobalSettings());
    }

    //вызвращает список тэгов, начинающихся на строку, заданную в параметре query
    //если query == null, возвращает все тэги
    //авторизация не требуется
    @GetMapping("/tag")
    public ResponseEntity<TagResponse> tag(@RequestParam(required = false) String query) {
        return ResponseEntity.ok(tagService.getTags(query));
    }
}
