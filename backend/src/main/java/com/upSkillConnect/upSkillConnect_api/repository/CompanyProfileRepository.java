package com.upSkillConnect.upSkillConnect_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upSkillConnect.upSkillConnect_api.entity.CompanyProfile;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {
    boolean existsByCompanyName(String companyName);

    Optional<CompanyProfile> findById(long id);

}