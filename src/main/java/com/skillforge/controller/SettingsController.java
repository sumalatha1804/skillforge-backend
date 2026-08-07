package com.skillforge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillforge.entity.User;
import com.skillforge.service.SettingsService;

@RestController
@RequestMapping("/settings")
@CrossOrigin("*")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @PutMapping("/{id}")
    public User updateSettings(@PathVariable Long id,
                               @RequestBody User user) {

        return settingsService.updateSettings(id, user);
    }
}