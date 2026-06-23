package com.upSkillConnect.upSkillConnect_api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upSkillConnect.upSkillConnect_api.auth.dto.CompanyRegisterRequestDTO;
import com.upSkillConnect.upSkillConnect_api.common.ApiResponseDTO;
import com.upSkillConnect.upSkillConnect_api.entity.CompanyProfile;
import com.upSkillConnect.upSkillConnect_api.entity.User;
import com.upSkillConnect.upSkillConnect_api.entity.enums.Role;
import com.upSkillConnect.upSkillConnect_api.exception.CompanyNameAlreadyExistsException;
import com.upSkillConnect.upSkillConnect_api.exception.EmailAlreadyExistsException;
import com.upSkillConnect.upSkillConnect_api.repository.CompanyProfileRepository;
import com.upSkillConnect.upSkillConnect_api.repository.UserRepository;
import com.upSkillConnect.upSkillConnect_api.entity.enums.Status;
import com.upSkillConnect.upSkillConnect_api.entity.shared.Address;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final CompanyProfileRepository companyProfileRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            CompanyProfileRepository companyProfileRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.companyProfileRepository = companyProfileRepository;
    }

    // public ApiResponseDTO<Void> registerSeeker(CompanyRegisterRequestDTO
    // requestDTO) {

    // return new ApiResponseDTO<>("Job Seeker registered successfully", true);
    // }

    public ApiResponseDTO<Void> registerCompany(CompanyRegisterRequestDTO companyRegisterRequestDTO) {
        if (userRepository.existsByEmail(companyRegisterRequestDTO.getCompanyEmail())) {
            throw new EmailAlreadyExistsException("This Email already exists");
        }

        if (companyProfileRepository.existsByCompanyName(companyRegisterRequestDTO.getCompanyName())) {
            throw new CompanyNameAlreadyExistsException("Company name already exists");
        }

        User company = new User();
        CompanyProfile companyProfile = new CompanyProfile();

        companyProfile.setCompanyName(companyRegisterRequestDTO.getCompanyName());
        company.setEmail(companyRegisterRequestDTO.getCompanyEmail());
        company.setPassword(passwordEncoder.encode(companyRegisterRequestDTO.getPassword()));
        companyProfile.setIndustry(companyRegisterRequestDTO.getIndustry());
        companyProfile.setCompanySize(companyRegisterRequestDTO.getCompanySize());
        companyProfile.setCompanyWebsite(companyRegisterRequestDTO.getCompanyWebsite());

        Address address = new Address();
        address.setCity(companyRegisterRequestDTO.getAddressDTO().getCity());
        address.setDistrict(companyRegisterRequestDTO.getAddressDTO().getDistrict());
        address.setCountry(companyRegisterRequestDTO.getAddressDTO().getCountry());
        address.setLatitude(companyRegisterRequestDTO.getAddressDTO().getLatitude());
        address.setLongitude(companyRegisterRequestDTO.getAddressDTO().getLongitude());
        address.setFormattedAddress(companyRegisterRequestDTO.getAddressDTO().getFormattedAddress());

        companyProfile.setCompanyLogo(companyRegisterRequestDTO.getCompanyLogo());
        companyProfile.setCompanyBio(companyRegisterRequestDTO.getCompanyBio());
        company.setStatus(Status.PENDING);
        company.setRole(Role.COMPANY);

        userRepository.save(company);

        companyProfile.setUser(company);
        companyProfile.setCompanyAddress(address);

        companyProfileRepository.save(companyProfile);

        return new ApiResponseDTO<>("Company Account registered successfully", true, null, null);
    }
}