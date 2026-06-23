package com.upSkillConnect.upSkillConnect_api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upSkillConnect.upSkillConnect_api.auth.dto.CompanyRegisterRequestDTO;
import com.upSkillConnect.upSkillConnect_api.common.ApiResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    // @PostMapping("/register/seeker")
    // public ResponseEntity<ApiResponseDTO<Void>> registerSeeker(
    //         @RequestBody CompanyRegisterRequestDTO registerSeekerDTO) {
    //     return ResponseEntity.status(
    //             HttpStatus.CREATED).body(
    //                     authService.registerSeeker(
    //                             registerSeekerDTO));
    // }

    @PostMapping("/register/company")
    public ResponseEntity<ApiResponseDTO<Void>> registerCompany(
            @Valid @RequestBody CompanyRegisterRequestDTO companyRegisterRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerCompany(companyRegisterRequestDTO));
    }
}