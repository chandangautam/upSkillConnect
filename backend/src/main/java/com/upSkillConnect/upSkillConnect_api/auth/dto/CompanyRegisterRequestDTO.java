package com.upSkillConnect.upSkillConnect_api.auth.dto;

import com.upSkillConnect.upSkillConnect_api.common.sharedDTO.AddressDTO;
import com.upSkillConnect.upSkillConnect_api.entity.enums.CompanySize;
import com.upSkillConnect.upSkillConnect_api.entity.enums.Industry;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CompanyRegisterRequestDTO {
    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name must not exceed 100 characters")
    private String companyName;

    @NotBlank(message = "Company email is required")
    @Email(message = "Invalid email format")
    private String companyEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be atleast 8 characters")
    private String password;

    @NotNull(message = "Industry is required")
    private Industry industry;

    private CompanySize companySize;

    @Pattern(regexp = "^(https?://)?([\\w\\-]+\\.)+[\\w\\-]+(/.*)?$", message = "Invalid website URL")
    private String companyWebsite;

    @NotNull(message = "Address is required")
    @Valid
    private AddressDTO addressDTO;

    @Size(max = 255, message = "Logo URL is too long")
    private String companyLogo;

    @Size(max = 1000, message = "About must not exceed 1000 characters")
    private String companyBio;

    public CompanyRegisterRequestDTO() {

    }

    public CompanyRegisterRequestDTO(String companyName, String companyEmail, String password, Industry industry,
            CompanySize companySize, String companyWebsite, AddressDTO addressDTO, String companyLogo,
            String companyBio) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.password = password;
        this.industry = industry;
        this.companySize = companySize;
        this.companyWebsite = companyWebsite;
        this.addressDTO = addressDTO;
        this.companyLogo = companyLogo;
        this.companyBio = companyBio;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public Industry getIndustry() {
        return industry;
    }

    public CompanySize getCompanySize() {
        return companySize;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getCompanyBio() {
        return companyBio;
    }
}