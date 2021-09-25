package com.ilmirbaichurin.blogengine.controller;

import com.ilmirbaichurin.blogengine.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class ApiAuthController {

    public final UserService userService;

    public ApiAuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> check() {
        return ResponseEntity.ok(userService.getAuthCheck());
    }
}
