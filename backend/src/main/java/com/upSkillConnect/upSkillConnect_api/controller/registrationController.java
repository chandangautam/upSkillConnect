package com.upSkillConnect.upSkillConnect_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upSkillConnect.upSkillConnect_api.entity.userEntity;

@RestController
@RequestMapping("/registration")
public class registrationController {

    private Map<Long, userEntity> registrationEntries = new HashMap<>();

    @GetMapping("/company")
    public ArrayList<userEntity> getAll() {
        return new ArrayList<>(registrationEntries.values());
    }

    @PostMapping("/company")
    public String createUserRegistration(@RequestBody userEntity companyRegistration) {
        registrationEntries.put(companyRegistration.getId(), companyRegistration);
        return "Your account has been created!";
    }

    @GetMapping("/id/{userId}")
    public userEntity getRegistrationById(@PathVariable Long userId) {
        return registrationEntries.get(userId); 
    }
}