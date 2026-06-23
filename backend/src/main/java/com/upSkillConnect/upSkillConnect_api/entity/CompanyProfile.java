package com.upSkillConnect.upSkillConnect_api.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.upSkillConnect.upSkillConnect_api.entity.enums.CompanySize;
import com.upSkillConnect.upSkillConnect_api.entity.enums.Industry;
import com.upSkillConnect.upSkillConnect_api.entity.shared.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_profile")
@EntityListeners(AuditingEntityListener.class)
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private User user;

    @Column(name = "company_name", unique = true, nullable = false)
    private String companyName;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_size", nullable = false)
    private CompanySize companySize;

    @Enumerated(EnumType.STRING)
    @Column(name = "industry", nullable = false)
    private Industry industry;

    @Column(name = "company_website", nullable = true)
    private String companyWebsite;

    @Column(name = "company_bio", columnDefinition = "TEXT", nullable = true)
    private String companyBio;

    @Column(name = "company_logo", nullable = true)
    private String companyLogo;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CompanyProfile() {

    }

    public CompanyProfile(User user, String companyName, Address address, CompanySize companySize,
            Industry industry,
            String companyWebsite,
            String companyBio, String companyLogo) {
        this.user = user;
        this.companyName = companyName;
        this.address = address;
        this.companySize = companySize;
        this.industry = industry;
        this.companyWebsite = companyWebsite;
        this.companyBio = companyBio;
        this.companyLogo = companyLogo;
    }

    public long getCompanyId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getCompanyAddress() {
        return address;
    }

    public void setCompanyAddress(Address address) {
        this.address = address;
    }

    public CompanySize getCompanySize() {
        return companySize;
    }

    public void setCompanySize(CompanySize companySize) {
        this.companySize = companySize;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyBio() {
        return companyBio;
    }

    public void setCompanyBio(String companyBio) {
        this.companyBio = companyBio;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}